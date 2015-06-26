--
-- PostgreSQL database dump
--

-- Dumped from database version 9.3.5
-- Dumped by pg_dump version 9.3.5
-- Started on 2015-06-26 10:34:24 BRT

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- TOC entry 179 (class 3079 OID 11791)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2033 (class 0 OID 0)
-- Dependencies: 179
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 170 (class 1259 OID 16385)
-- Name: admin; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE admin (
    login character varying NOT NULL,
    senha_md5 character varying
);


ALTER TABLE public.admin OWNER TO postgres;

--
-- TOC entry 171 (class 1259 OID 16391)
-- Name: classificacao; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE classificacao (
    id integer NOT NULL,
    descricao character varying
);


ALTER TABLE public.classificacao OWNER TO postgres;

--
-- TOC entry 172 (class 1259 OID 16397)
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
-- TOC entry 2034 (class 0 OID 0)
-- Dependencies: 172
-- Name: classificacao_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE classificacao_id_seq OWNED BY classificacao.id;


--
-- TOC entry 173 (class 1259 OID 16399)
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
    duracao_min integer NOT NULL
);


ALTER TABLE public.filme OWNER TO postgres;

--
-- TOC entry 174 (class 1259 OID 16405)
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
-- TOC entry 2035 (class 0 OID 0)
-- Dependencies: 174
-- Name: filme_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE filme_id_seq OWNED BY filme.id;


--
-- TOC entry 175 (class 1259 OID 16407)
-- Name: genero; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE genero (
    id integer NOT NULL,
    descricao character varying NOT NULL
);


ALTER TABLE public.genero OWNER TO postgres;

--
-- TOC entry 176 (class 1259 OID 16413)
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
-- TOC entry 2036 (class 0 OID 0)
-- Dependencies: 176
-- Name: genero_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE genero_id_seq OWNED BY genero.id;


--
-- TOC entry 177 (class 1259 OID 16415)
-- Name: sessao; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE sessao (
    id integer NOT NULL,
    filme integer,
    horario timestamp without time zone,
    valor_adulto money,
    valor_estudante money,
    valor_idoso money,
    is3d boolean,
    is_legendado boolean,
    sala integer
);


ALTER TABLE public.sessao OWNER TO postgres;

--
-- TOC entry 178 (class 1259 OID 16418)
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
-- TOC entry 2037 (class 0 OID 0)
-- Dependencies: 178
-- Name: sessao_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE sessao_id_seq OWNED BY sessao.id;


--
-- TOC entry 1889 (class 2604 OID 16420)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY classificacao ALTER COLUMN id SET DEFAULT nextval('classificacao_id_seq'::regclass);


--
-- TOC entry 1890 (class 2604 OID 16421)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY filme ALTER COLUMN id SET DEFAULT nextval('filme_id_seq'::regclass);


--
-- TOC entry 1891 (class 2604 OID 16422)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY genero ALTER COLUMN id SET DEFAULT nextval('genero_id_seq'::regclass);


--
-- TOC entry 1892 (class 2604 OID 16423)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY sessao ALTER COLUMN id SET DEFAULT nextval('sessao_id_seq'::regclass);


--
-- TOC entry 2017 (class 0 OID 16385)
-- Dependencies: 170
-- Data for Name: admin; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO admin (login, senha_md5) VALUES ('admin', '"21232f297a57a5a743894a0e4a801fc3"');


--
-- TOC entry 2018 (class 0 OID 16391)
-- Dependencies: 171
-- Data for Name: classificacao; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO classificacao (id, descricao) VALUES (1, 'livre');
INSERT INTO classificacao (id, descricao) VALUES (2, '12+');
INSERT INTO classificacao (id, descricao) VALUES (3, '16+');
INSERT INTO classificacao (id, descricao) VALUES (4, '18+');
INSERT INTO classificacao (id, descricao) VALUES (5, '14+');


--
-- TOC entry 2038 (class 0 OID 0)
-- Dependencies: 172
-- Name: classificacao_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('classificacao_id_seq', 5, true);


--
-- TOC entry 2020 (class 0 OID 16399)
-- Dependencies: 173
-- Data for Name: filme; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO filme (titulo, genero, classificacao, direcao, elenco, sinopse, link_trailer, id, duracao_min) VALUES ('mad max', 1, 2, 'superman', 'chimbinha;ekko', 'o mad max vence', 'https://www.youtube.com/watch?v=dQw4w9WgXcQ', 1, 120);
INSERT INTO filme (titulo, genero, classificacao, direcao, elenco, sinopse, link_trailer, id, duracao_min) VALUES ('jurassic world', 1, 2, 'direcao', 'amarante sniper 666', 'dino', 'https://www.youtube.com/watch?v=dQw4w9WgXcQ', 2, 110);


--
-- TOC entry 2039 (class 0 OID 0)
-- Dependencies: 174
-- Name: filme_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('filme_id_seq', 7, true);


--
-- TOC entry 2022 (class 0 OID 16407)
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
-- TOC entry 2040 (class 0 OID 0)
-- Dependencies: 176
-- Name: genero_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('genero_id_seq', 9, true);


--
-- TOC entry 2024 (class 0 OID 16415)
-- Dependencies: 177
-- Data for Name: sessao; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO sessao (id, filme, horario, valor_adulto, valor_estudante, valor_idoso, is3d, is_legendado, sala) VALUES (1, 1, '2015-12-01 18:00:00', 'R$ 40,00', 'R$ 20,00', 'R$ 21,00', true, true, 7);
INSERT INTO sessao (id, filme, horario, valor_adulto, valor_estudante, valor_idoso, is3d, is_legendado, sala) VALUES (2, 2, '2015-12-01 20:30:00', 'R$ 39,00', 'R$ 19,00', 'R$ 20,00', true, true, 7);


--
-- TOC entry 2041 (class 0 OID 0)
-- Dependencies: 178
-- Name: sessao_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('sessao_id_seq', 2, true);


--
-- TOC entry 1894 (class 2606 OID 16425)
-- Name: admin_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY admin
    ADD CONSTRAINT admin_pkey PRIMARY KEY (login);


--
-- TOC entry 1896 (class 2606 OID 16427)
-- Name: classificacao_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY classificacao
    ADD CONSTRAINT classificacao_pk PRIMARY KEY (id);


--
-- TOC entry 1898 (class 2606 OID 16429)
-- Name: classificacao_unique; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY classificacao
    ADD CONSTRAINT classificacao_unique UNIQUE (descricao);


--
-- TOC entry 1900 (class 2606 OID 16431)
-- Name: filme_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY filme
    ADD CONSTRAINT filme_pk PRIMARY KEY (id);


--
-- TOC entry 1902 (class 2606 OID 16433)
-- Name: filme_titulo_unique; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY filme
    ADD CONSTRAINT filme_titulo_unique UNIQUE (titulo);


--
-- TOC entry 1904 (class 2606 OID 16435)
-- Name: genero_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY genero
    ADD CONSTRAINT genero_pk PRIMARY KEY (id);


--
-- TOC entry 1906 (class 2606 OID 16437)
-- Name: sessao_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY sessao
    ADD CONSTRAINT sessao_pk PRIMARY KEY (id);


--
-- TOC entry 1908 (class 2606 OID 16439)
-- Name: sessao_unique_horario_sala; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY sessao
    ADD CONSTRAINT sessao_unique_horario_sala UNIQUE (horario, sala);


--
-- TOC entry 1909 (class 2606 OID 16440)
-- Name: sessao_filme_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY sessao
    ADD CONSTRAINT sessao_filme_fk FOREIGN KEY (filme) REFERENCES filme(id) ON DELETE CASCADE;


--
-- TOC entry 2032 (class 0 OID 0)
-- Dependencies: 6
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2015-06-26 10:34:25 BRT

--
-- PostgreSQL database dump complete
--

