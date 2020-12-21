insert into users (user_name, password, enabled, name, lastname, email) values ('diegonieto', '$2a$10$HQIQL9GL.FGuAcZTCaYkl.OPDsilzcgPVSbV02Rc5xLaF0Own4Sgq', 1, 'Diego', 'Nieto', 'dhyego.nieto@gmail.com');
insert into users (user_name, password, enabled, name, lastname, email) values ('LauraNieto', '$2a$10$FrmNbUrvxkFqLF6tPBAacey.vVOqR2mhb.tTPkzkuHpluPFvwHqei', 1, 'Laura', 'Nieto', 'laura.nieto@gmail.com');
insert into users (user_name, password, enabled, name, lastname, email) values ('juannieto', '$2a$10$TVJmPRsnijhI9AFyHkfXCufLS.5CtGvB3V3bmGvYM3Wi5ClwcbWgq', 1, 'Sebastian', 'Nieto', 'sebastian.nieto@gmail.com');
insert into users (user_name, password, enabled, name, lastname, email) values ('DeimosNieto', '$2a$10$54C0jcS5FgB7eZHIP.9V3epfHgMextpkvQkoKEap1fevmgV6kDTYW', 0, 'Deimos', 'Nieto', 'deimos.nieto@gmail.com');

insert into role (name) values ('ROLE_USER');
insert into role (name) values ('ROLE_ADMIN');

insert into user_role(user_id, role_id) values (1, 1);
insert into user_role(user_id, role_id) values (2, 1);
insert into user_role(user_id, role_id) values (3, 1);
insert into user_role(user_id, role_id) values (3, 2);
