create table topics (
    id bigint not null auto_increment,
    titulo varchar(200) not null,
    mensaje varchar(500) not null,
    fechacreacion datetime not null,
    status tinyint not null,
    usuario_id bigint not null,
    primary key (id),
    constraint fk_topics_usuarios_id foreign key (usuario_id) references usuarios (id)
);
