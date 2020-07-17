create sequence hibernate_sequence start 1 increment 1
create table medico (id int8 not null, cargo varchar(255), estado varchar(255), nombre varchar(255), primary key (id))
create table paciente (id int8 not null, estado varchar(255), nombre varchar(255), medico int8, primary key (id))
alter table paciente add constraint FKrsts7lyd7yekb4t02xamg6qfw foreign key (medico) references medico
create sequence hibernate_sequence start 1 increment 1
create table medico (id int8 not null, cargo varchar(255), estado varchar(255), nombre varchar(255), primary key (id))
create table paciente (id int8 not null, estado varchar(255), nombre varchar(255), medico int8, primary key (id))
alter table paciente add constraint FKrsts7lyd7yekb4t02xamg6qfw foreign key (medico) references medico
create sequence hibernate_sequence start 1 increment 1
create table medico (id int8 not null, cargo varchar(255), estado varchar(255), nombre varchar(255), primary key (id))
create table paciente (id int8 not null, estado varchar(255), nombre varchar(255), medico int8, primary key (id))
alter table paciente add constraint FKrsts7lyd7yekb4t02xamg6qfw foreign key (medico) references medico
create sequence hibernate_sequence start 1 increment 1
create table medico (id int8 not null, cargo varchar(255), estado varchar(255), nombre varchar(255), primary key (id))
create table paciente (id int8 not null, estado varchar(255), nombre varchar(255), medico_id int8, primary key (id))
alter table paciente add constraint FKdb6ggrau4kxv0xcu8n17bmn9u foreign key (medico_id) references medico
create sequence hibernate_sequence start 1 increment 1
create table medico (id int8 not null, cargo varchar(255), estado varchar(255), nombre varchar(255), primary key (id))
create table paciente (id int8 not null, estado varchar(255), nombre varchar(255), medico_id int8, primary key (id))
alter table paciente add constraint FKdb6ggrau4kxv0xcu8n17bmn9u foreign key (medico_id) references medico
create sequence hibernate_sequence start 1 increment 1
create table medico (id  bigserial not null, cargo varchar(255), estado varchar(255), nombre varchar(255), primary key (id))
create table paciente (id int8 not null, estado varchar(255), nombre varchar(255), medico_id int8, primary key (id))
alter table paciente add constraint FKdb6ggrau4kxv0xcu8n17bmn9u foreign key (medico_id) references medico
