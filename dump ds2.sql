--
-- PostgreSQL database dump
--

-- Dumped from database version 9.3.5
-- Dumped by pg_dump version 9.3.1
-- Started on 2015-07-03 06:09:35

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- TOC entry 179 (class 3079 OID 11750)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 1995 (class 0 OID 0)
-- Dependencies: 179
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 170 (class 1259 OID 57509)
-- Name: admin; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE admin (
    login character varying NOT NULL,
    senha_md5 character varying
);


ALTER TABLE public.admin OWNER TO postgres;

--
-- TOC entry 171 (class 1259 OID 57515)
-- Name: classificacao; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE classificacao (
    id integer NOT NULL,
    descricao character varying
);


ALTER TABLE public.classificacao OWNER TO postgres;

--
-- TOC entry 172 (class 1259 OID 57521)
-- Name: classificacao_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE classificacao_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.classificacao_id_seq OWNER TO postgres;

--
-- TOC entry 1996 (class 0 OID 0)
-- Dependencies: 172
-- Name: classificacao_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE classificacao_id_seq OWNED BY classificacao.id;


--
-- TOC entry 173 (class 1259 OID 57523)
-- Name: filme; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE filme (
    titulo character varying,
    genero integer,
    classificacao integer,
    direcao character varying,
    elenco character varying,
    sinopse text,
    link_trailer character varying,
    id integer NOT NULL,
    duracao_min integer,
    url_cartaz character varying DEFAULT 'sem_cartaz.png'::character varying NOT NULL
);


ALTER TABLE public.filme OWNER TO postgres;

--
-- TOC entry 174 (class 1259 OID 57529)
-- Name: filme_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE filme_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.filme_id_seq OWNER TO postgres;

--
-- TOC entry 1997 (class 0 OID 0)
-- Dependencies: 174
-- Name: filme_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE filme_id_seq OWNED BY filme.id;


--
-- TOC entry 175 (class 1259 OID 57531)
-- Name: genero; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE genero (
    id integer NOT NULL,
    descricao character varying NOT NULL
);


ALTER TABLE public.genero OWNER TO postgres;

--
-- TOC entry 176 (class 1259 OID 57537)
-- Name: genero_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE genero_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.genero_id_seq OWNER TO postgres;

--
-- TOC entry 1998 (class 0 OID 0)
-- Dependencies: 176
-- Name: genero_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE genero_id_seq OWNED BY genero.id;


--
-- TOC entry 177 (class 1259 OID 57539)
-- Name: sessao; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE sessao (
    id integer NOT NULL,
    filme integer,
    horario timestamp without time zone,
    valor_adulto numeric NOT NULL,
    valor_estudante numeric,
    valor_idoso numeric,
    is3d boolean,
    is_legendado boolean,
    sala integer
);


ALTER TABLE public.sessao OWNER TO postgres;

--
-- TOC entry 178 (class 1259 OID 57542)
-- Name: sessao_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE sessao_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.sessao_id_seq OWNER TO postgres;

--
-- TOC entry 1999 (class 0 OID 0)
-- Dependencies: 178
-- Name: sessao_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE sessao_id_seq OWNED BY sessao.id;


--
-- TOC entry 1850 (class 2604 OID 57544)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY classificacao ALTER COLUMN id SET DEFAULT nextval('classificacao_id_seq'::regclass);


--
-- TOC entry 1851 (class 2604 OID 57545)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY filme ALTER COLUMN id SET DEFAULT nextval('filme_id_seq'::regclass);


--
-- TOC entry 1853 (class 2604 OID 57546)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY genero ALTER COLUMN id SET DEFAULT nextval('genero_id_seq'::regclass);


--
-- TOC entry 1854 (class 2604 OID 57547)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY sessao ALTER COLUMN id SET DEFAULT nextval('sessao_id_seq'::regclass);


--
-- TOC entry 1979 (class 0 OID 57509)
-- Dependencies: 170
-- Data for Name: admin; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO admin (login, senha_md5) VALUES ('admin', '21232f297a57a5a743894a0e4a801fc3');


--
-- TOC entry 1980 (class 0 OID 57515)
-- Dependencies: 171
-- Data for Name: classificacao; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO classificacao (id, descricao) VALUES (1, 'livre');
INSERT INTO classificacao (id, descricao) VALUES (2, '12+');
INSERT INTO classificacao (id, descricao) VALUES (3, '16+');
INSERT INTO classificacao (id, descricao) VALUES (4, '18+');
INSERT INTO classificacao (id, descricao) VALUES (5, '14+');


--
-- TOC entry 2000 (class 0 OID 0)
-- Dependencies: 172
-- Name: classificacao_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('classificacao_id_seq', 5, true);


--
-- TOC entry 1982 (class 0 OID 57523)
-- Dependencies: 173
-- Data for Name: filme; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO filme (titulo, genero, classificacao, direcao, elenco, sinopse, link_trailer, id, duracao_min, url_cartaz) VALUES ('mad max', 1, 2, 'superman', 'chimbinha;ekko', 'o mad max vence', 'https://www.youtube.com/watch?v=dQw4w9WgXcQ', 1, 120, 'sem_cartaz.png');
INSERT INTO filme (titulo, genero, classificacao, direcao, elenco, sinopse, link_trailer, id, duracao_min, url_cartaz) VALUES ('jurassic world', 1, 2, 'direcao', 'amarante sniper 666', 'dino', 'https://www.youtube.com/watch?v=dQw4w9WgXcQ', 2, 119, 'sem_cartaz.png');
INSERT INTO filme (titulo, genero, classificacao, direcao, elenco, sinopse, link_trailer, id, duracao_min, url_cartaz) VALUES ('ultimo', 1, 1, 'biaud', 'biaud', 'biaud', 'biaud', 6, 61, 'sem_cartaz.png');
INSERT INTO filme (titulo, genero, classificacao, direcao, elenco, sinopse, link_trailer, id, duracao_min, url_cartaz) VALUES ('hao123', 1, 1, 'biaud', 'biaud', 'biaud', 'biaud', 5, 61, 'sem_cartaz.png');


--
-- TOC entry 2001 (class 0 OID 0)
-- Dependencies: 174
-- Name: filme_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('filme_id_seq', 6, true);


--
-- TOC entry 1984 (class 0 OID 57531)
-- Dependencies: 175
-- Data for Name: genero; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO genero (id, descricao) VALUES (1, 'acao');
INSERT INTO genero (id, descricao) VALUES (2, 'romance');
INSERT INTO genero (id, descricao) VALUES (3, 'comedia');
INSERT INTO genero (id, descricao) VALUES (4, 'drama');
INSERT INTO genero (id, descricao) VALUES (5, 'suspense');
INSERT INTO genero (id, descricao) VALUES (6, 'classico');
INSERT INTO genero (id, descricao) VALUES (7, 'faroeste');
INSERT INTO genero (id, descricao) VALUES (8, 'outro');
INSERT INTO genero (id, descricao) VALUES (9, 'aventura');


--
-- TOC entry 2002 (class 0 OID 0)
-- Dependencies: 176
-- Name: genero_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('genero_id_seq', 10, true);


--
-- TOC entry 1986 (class 0 OID 57539)
-- Dependencies: 177
-- Data for Name: sessao; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO sessao (id, filme, horario, valor_adulto, valor_estudante, valor_idoso, is3d, is_legendado, sala) VALUES (2, 2, '2015-12-01 20:30:00', 39.00, 19.00, 20.00, true, true, 7);
INSERT INTO sessao (id, filme, horario, valor_adulto, valor_estudante, valor_idoso, is3d, is_legendado, sala) VALUES (1, 1, '2015-12-01 18:00:00', 40.00, 20.00, 21.00, true, true, 7);
INSERT INTO sessao (id, filme, horario, valor_adulto, valor_estudante, valor_idoso, is3d, is_legendado, sala) VALUES (9, 5, '2015-07-02 01:12:35.702', 1500, 0, 0, false, true, 8);
INSERT INTO sessao (id, filme, horario, valor_adulto, valor_estudante, valor_idoso, is3d, is_legendado, sala) VALUES (10, 5, '2015-07-02 02:54:57.512', 1500, 0, 0, false, true, 0);
INSERT INTO sessao (id, filme, horario, valor_adulto, valor_estudante, valor_idoso, is3d, is_legendado, sala) VALUES (11, 5, '2015-07-02 02:54:57.715', 1500, 0, 0, false, true, 1);
INSERT INTO sessao (id, filme, horario, valor_adulto, valor_estudante, valor_idoso, is3d, is_legendado, sala) VALUES (12, 5, '2015-07-02 02:54:57.73', 1500, 0, 0, false, true, 2);
INSERT INTO sessao (id, filme, horario, valor_adulto, valor_estudante, valor_idoso, is3d, is_legendado, sala) VALUES (13, 5, '2015-07-02 02:54:57.762', 1500, 0, 0, false, true, 3);
INSERT INTO sessao (id, filme, horario, valor_adulto, valor_estudante, valor_idoso, is3d, is_legendado, sala) VALUES (14, 5, '2015-07-02 02:54:57.793', 1500, 0, 0, false, true, 4);
INSERT INTO sessao (id, filme, horario, valor_adulto, valor_estudante, valor_idoso, is3d, is_legendado, sala) VALUES (15, 5, '2015-07-02 02:54:57.824', 1500, 0, 0, false, true, 5);
INSERT INTO sessao (id, filme, horario, valor_adulto, valor_estudante, valor_idoso, is3d, is_legendado, sala) VALUES (16, 5, '2015-07-02 02:54:57.855', 1500, 0, 0, false, true, 6);
INSERT INTO sessao (id, filme, horario, valor_adulto, valor_estudante, valor_idoso, is3d, is_legendado, sala) VALUES (17, 5, '2015-07-02 02:54:57.871', 1500, 0, 0, false, true, 7);
INSERT INTO sessao (id, filme, horario, valor_adulto, valor_estudante, valor_idoso, is3d, is_legendado, sala) VALUES (18, 5, '2015-07-02 02:54:57.902', 1500, 0, 0, false, true, 8);
INSERT INTO sessao (id, filme, horario, valor_adulto, valor_estudante, valor_idoso, is3d, is_legendado, sala) VALUES (19, 5, '2015-07-02 02:54:57.933', 1500, 0, 0, false, true, 9);
INSERT INTO sessao (id, filme, horario, valor_adulto, valor_estudante, valor_idoso, is3d, is_legendado, sala) VALUES (20, 5, '2015-07-02 02:54:57.964', 1500, 0, 0, false, true, 10);
INSERT INTO sessao (id, filme, horario, valor_adulto, valor_estudante, valor_idoso, is3d, is_legendado, sala) VALUES (21, 5, '2015-07-02 02:54:57.98', 1500, 0, 0, false, true, 11);
INSERT INTO sessao (id, filme, horario, valor_adulto, valor_estudante, valor_idoso, is3d, is_legendado, sala) VALUES (22, 5, '2015-07-02 02:54:58.011', 1500, 0, 0, false, true, 12);
INSERT INTO sessao (id, filme, horario, valor_adulto, valor_estudante, valor_idoso, is3d, is_legendado, sala) VALUES (23, 5, '2015-07-02 02:54:58.042', 1500, 0, 0, false, true, 13);
INSERT INTO sessao (id, filme, horario, valor_adulto, valor_estudante, valor_idoso, is3d, is_legendado, sala) VALUES (24, 5, '2015-07-02 02:54:58.074', 1500, 0, 0, false, true, 14);
INSERT INTO sessao (id, filme, horario, valor_adulto, valor_estudante, valor_idoso, is3d, is_legendado, sala) VALUES (25, 5, '2015-07-02 02:54:58.105', 1500, 0, 0, false, true, 15);
INSERT INTO sessao (id, filme, horario, valor_adulto, valor_estudante, valor_idoso, is3d, is_legendado, sala) VALUES (26, 5, '2015-07-02 02:54:58.136', 1500, 0, 0, false, true, 16);
INSERT INTO sessao (id, filme, horario, valor_adulto, valor_estudante, valor_idoso, is3d, is_legendado, sala) VALUES (27, 5, '2015-07-02 02:54:58.167', 1500, 0, 0, false, true, 17);
INSERT INTO sessao (id, filme, horario, valor_adulto, valor_estudante, valor_idoso, is3d, is_legendado, sala) VALUES (28, 5, '2015-07-02 02:54:58.198', 1500, 0, 0, false, true, 18);
INSERT INTO sessao (id, filme, horario, valor_adulto, valor_estudante, valor_idoso, is3d, is_legendado, sala) VALUES (29, 5, '2015-07-02 02:54:58.23', 1500, 0, 0, false, true, 19);
INSERT INTO sessao (id, filme, horario, valor_adulto, valor_estudante, valor_idoso, is3d, is_legendado, sala) VALUES (30, 5, '2015-07-02 02:54:58.245', 1500, 0, 0, false, true, 20);
INSERT INTO sessao (id, filme, horario, valor_adulto, valor_estudante, valor_idoso, is3d, is_legendado, sala) VALUES (31, 5, '2015-07-02 02:54:58.276', 1500, 0, 0, false, true, 21);
INSERT INTO sessao (id, filme, horario, valor_adulto, valor_estudante, valor_idoso, is3d, is_legendado, sala) VALUES (32, 5, '2015-07-02 02:54:58.308', 1500, 0, 0, false, true, 22);
INSERT INTO sessao (id, filme, horario, valor_adulto, valor_estudante, valor_idoso, is3d, is_legendado, sala) VALUES (33, 5, '2015-07-02 02:54:58.339', 1500, 0, 0, false, true, 23);
INSERT INTO sessao (id, filme, horario, valor_adulto, valor_estudante, valor_idoso, is3d, is_legendado, sala) VALUES (34, 5, '2015-07-02 02:54:58.354', 1500, 0, 0, false, true, 24);
INSERT INTO sessao (id, filme, horario, valor_adulto, valor_estudante, valor_idoso, is3d, is_legendado, sala) VALUES (35, 5, '2015-07-02 02:54:58.386', 1500, 0, 0, false, true, 25);
INSERT INTO sessao (id, filme, horario, valor_adulto, valor_estudante, valor_idoso, is3d, is_legendado, sala) VALUES (36, 5, '2015-07-02 02:54:58.417', 1500, 0, 0, false, true, 26);
INSERT INTO sessao (id, filme, horario, valor_adulto, valor_estudante, valor_idoso, is3d, is_legendado, sala) VALUES (37, 5, '2015-07-02 02:54:58.448', 1500, 0, 0, false, true, 27);
INSERT INTO sessao (id, filme, horario, valor_adulto, valor_estudante, valor_idoso, is3d, is_legendado, sala) VALUES (38, 5, '2015-07-02 02:54:58.464', 1500, 0, 0, false, true, 28);
INSERT INTO sessao (id, filme, horario, valor_adulto, valor_estudante, valor_idoso, is3d, is_legendado, sala) VALUES (39, 5, '2015-07-02 02:54:58.495', 1500, 0, 0, false, true, 29);
INSERT INTO sessao (id, filme, horario, valor_adulto, valor_estudante, valor_idoso, is3d, is_legendado, sala) VALUES (40, 5, '2015-07-02 02:54:58.526', 1500, 0, 0, false, true, 30);
INSERT INTO sessao (id, filme, horario, valor_adulto, valor_estudante, valor_idoso, is3d, is_legendado, sala) VALUES (41, 5, '2015-07-02 02:54:58.557', 1500, 0, 0, false, true, 31);
INSERT INTO sessao (id, filme, horario, valor_adulto, valor_estudante, valor_idoso, is3d, is_legendado, sala) VALUES (42, 5, '2015-07-02 02:54:58.588', 1500, 0, 0, false, true, 32);
INSERT INTO sessao (id, filme, horario, valor_adulto, valor_estudante, valor_idoso, is3d, is_legendado, sala) VALUES (43, 5, '2015-07-02 02:54:58.62', 1500, 0, 0, false, true, 33);
INSERT INTO sessao (id, filme, horario, valor_adulto, valor_estudante, valor_idoso, is3d, is_legendado, sala) VALUES (44, 5, '2015-07-02 02:54:58.635', 1500, 0, 0, false, true, 34);
INSERT INTO sessao (id, filme, horario, valor_adulto, valor_estudante, valor_idoso, is3d, is_legendado, sala) VALUES (45, 5, '2015-07-02 02:54:58.682', 1500, 0, 0, false, true, 35);
INSERT INTO sessao (id, filme, horario, valor_adulto, valor_estudante, valor_idoso, is3d, is_legendado, sala) VALUES (46, 5, '2015-07-02 02:54:58.698', 1500, 0, 0, false, true, 36);
INSERT INTO sessao (id, filme, horario, valor_adulto, valor_estudante, valor_idoso, is3d, is_legendado, sala) VALUES (47, 5, '2015-07-02 02:54:58.729', 1500, 0, 0, false, true, 37);
INSERT INTO sessao (id, filme, horario, valor_adulto, valor_estudante, valor_idoso, is3d, is_legendado, sala) VALUES (48, 5, '2015-07-02 02:54:58.76', 1500, 0, 0, false, true, 38);
INSERT INTO sessao (id, filme, horario, valor_adulto, valor_estudante, valor_idoso, is3d, is_legendado, sala) VALUES (49, 5, '2015-07-02 02:54:58.791', 1500, 0, 0, false, true, 39);
INSERT INTO sessao (id, filme, horario, valor_adulto, valor_estudante, valor_idoso, is3d, is_legendado, sala) VALUES (50, 6, '2015-07-02 03:56:28.133', 1500, 0, 0, false, true, 0);


--
-- TOC entry 2003 (class 0 OID 0)
-- Dependencies: 178
-- Name: sessao_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('sessao_id_seq', 50, true);


--
-- TOC entry 1856 (class 2606 OID 57549)
-- Name: admin_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY admin
    ADD CONSTRAINT admin_pkey PRIMARY KEY (login);


--
-- TOC entry 1858 (class 2606 OID 57551)
-- Name: classificacao_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY classificacao
    ADD CONSTRAINT classificacao_pk PRIMARY KEY (id);


--
-- TOC entry 1860 (class 2606 OID 57553)
-- Name: classificacao_unique; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY classificacao
    ADD CONSTRAINT classificacao_unique UNIQUE (descricao);


--
-- TOC entry 1862 (class 2606 OID 57555)
-- Name: filme_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY filme
    ADD CONSTRAINT filme_pk PRIMARY KEY (id);


--
-- TOC entry 1864 (class 2606 OID 57557)
-- Name: filme_titulo_unique; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY filme
    ADD CONSTRAINT filme_titulo_unique UNIQUE (titulo);


--
-- TOC entry 1866 (class 2606 OID 57559)
-- Name: genero_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY genero
    ADD CONSTRAINT genero_pk PRIMARY KEY (id);


--
-- TOC entry 1868 (class 2606 OID 57561)
-- Name: sessao_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY sessao
    ADD CONSTRAINT sessao_pk PRIMARY KEY (id);


--
-- TOC entry 1870 (class 2606 OID 57563)
-- Name: sessao_unique_horario_sala; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY sessao
    ADD CONSTRAINT sessao_unique_horario_sala UNIQUE (horario, sala);


--
-- TOC entry 1871 (class 2606 OID 57564)
-- Name: sessao_filme_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY sessao
    ADD CONSTRAINT sessao_filme_fk FOREIGN KEY (filme) REFERENCES filme(id) ON DELETE CASCADE;


--
-- TOC entry 1994 (class 0 OID 0)
-- Dependencies: 6
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2015-07-03 06:09:35

--
-- PostgreSQL database dump complete
--

