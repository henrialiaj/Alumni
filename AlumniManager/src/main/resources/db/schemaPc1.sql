CREATE SEQUENCE users_user_id_seq START 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

CREATE SEQUENCE posts_id_seq START 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

CREATE SEQUENCE likes_like_id_seq START 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

CREATE SEQUENCE connection_connection_id_seq START 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

CREATE SEQUENCE comment_comment_id_seq START 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

CREATE TABLE IF NOT EXISTS public.users
(
    user_id integer NOT NULL DEFAULT nextval('users_user_id_seq'::regclass),
    email character varying(255) COLLATE pg_catalog."default",
    first_name character varying(255) COLLATE pg_catalog."default",
    last_name character varying(255) COLLATE pg_catalog."default",
    password character varying(255) COLLATE pg_catalog."default",
    role smallint,
    validity boolean,
    CONSTRAINT users_pkey PRIMARY KEY (user_id)
    )

CREATE TABLE IF NOT EXISTS public.posts
(
    id integer NOT NULL DEFAULT nextval('posts_id_seq'::regclass),
    content character varying(255) COLLATE pg_catalog."default",
    event_time timestamp(6) without time zone,
    picture_url character varying(255) COLLATE pg_catalog."default",
    "time" timestamp(6) without time zone,
    type character varying(255) COLLATE pg_catalog."default",
    user_id integer,
    CONSTRAINT posts_pkey PRIMARY KEY (id),
    CONSTRAINT fk5lidm6cqbc7u4xhqpxm898qme FOREIGN KEY (user_id)
    REFERENCES public.users (user_id) MATCH SIMPLE
                            ON UPDATE NO ACTION
                            ON DELETE NO ACTION
    )

CREATE TABLE IF NOT EXISTS public.likes
(
    like_id integer NOT NULL DEFAULT nextval('likes_like_id_seq'::regclass),
    id integer,
    user_id integer,
    CONSTRAINT likes_pkey PRIMARY KEY (like_id),
    CONSTRAINT fknvx9seeqqyy71bij291pwiwrg FOREIGN KEY (user_id)
    REFERENCES public.users (user_id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION,
    CONSTRAINT fkqc7vvfd4d23wg9c4wmsnwc1c4 FOREIGN KEY (id)
    REFERENCES public.posts (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    )

CREATE TABLE IF NOT EXISTS public.connection
(
    connection_id integer NOT NULL DEFAULT nextval('connection_connection_id_seq'::regclass),
    connection character varying(255) COLLATE pg_catalog."default",
    reciver_id integer,
    sender_id integer,
    CONSTRAINT connection_pkey PRIMARY KEY (connection_id),
    CONSTRAINT fk82codnlq7vlqmi9o9a4inpav3 FOREIGN KEY (sender_id)
    REFERENCES public.users (user_id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION,
    CONSTRAINT fkbrx84toeniipane3rbqvevyxw FOREIGN KEY (reciver_id)
    REFERENCES public.users (user_id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    )

CREATE TABLE IF NOT EXISTS public.comment
(
    comment_id integer NOT NULL DEFAULT nextval('comment_comment_id_seq'::regclass),
    comment_content character varying(255) COLLATE pg_catalog."default",
    id integer,
    user_id integer,
    CONSTRAINT comment_pkey PRIMARY KEY (comment_id),
    CONSTRAINT fkqm52p1v3o13hy268he0wcngr5 FOREIGN KEY (user_id)
    REFERENCES public.users (user_id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION,
    CONSTRAINT fkstnyfrltybtg8nlt2gwmwmw5u FOREIGN KEY (id)
    REFERENCES public.posts (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    )
