INSERT INTO fundaciones (id_fudacion, ruc, nombre_fundacion, eslogan, objetivo, correo, direccion, pagina_web, horarios, acronimo, logo_fundacion) VALUES (1, '', 'Fundación Familia Amor Animal', 'Protección, concienciación y defensa de animalitos', 'Por 8 años, FAAN ( Fundación Familia Amor Animal ) ha servido como santuario para perros maltratados, abandonados, descuidados y de alto rango en el área metropolitana de Cuenca, Ecuador, con un temporal refugio ubicado en Tarqui. Hay más de 150 perros a nuestro cuidado. FAAN es una organización ecuatoriana sin fines de lucro dedicada al bienestar y la seguridad de los animales en el área metropolitana de Cuenca.', 'info@faanecuador.org', 'Tarqui (sector estadio de Tarqui), Cuenca, Ecuador', 'https://www.faanecuador.org/', 'Siempre abierto', 'FAAN', 'faan.jpg');
INSERT INTO roles (id_rol, nombre_rol, estado_rol_activo) VALUES (1, 'SUPERADMINISTRADOR', true);
INSERT INTO roles (id_rol, nombre_rol, estado_rol_activo) VALUES (2, 'ADMINISTRADOR', true);
INSERT INTO personas (id_persona, identificacion, nombre1, nombre2, apellido1, apellido2, fecha_nacimiento, direccion, correo, telefono, celular, genero) VALUES (1, '', '','', '', '', null, '', 'correo', '', '', '');
INSERT INTO usuarios (id_usuario, username, password, foto_perfil, estado_usuario, token_password, id_persona) VALUE (1, 'ADMIN',  '123', '4bce1942-ba13-4569-9326-4eb87f663aed_userDefault.png', true, '', 1);
INSERT INTO users_roles (id_usuario, id_rol) VALUES (1,1);