alter table topicos add column activo tinyint;
update topicos set activo = 1;
