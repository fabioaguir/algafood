insert into cozinha (id, nome) values(1, 'Tailandesa');
insert into cozinha (id, nome) values(2, 'Indiana');

insert into restaurante (nome, taxa_frete, cozinha_id) values('Chines', 10, 1);
insert into restaurante (nome, taxa_frete, cozinha_id) values('Brasileiro', 20, 2);

insert into forma_pagamento (id, descricao) values(1, 'Boleto');
insert into forma_pagamento (id, descricao) values(2, 'Débito');
insert into forma_pagamento (id, descricao) values(3, 'Crédito');

insert into permissao (id, nome, descricao) values(1, 'ADMIN', 'Acesso administrador');
insert into permissao (id, nome, descricao) values(2, 'SUPER', 'Acesso supervisor');

insert into estado (id, nome) values(1, 'Pernambuco');
insert into estado (id, nome) values(2, 'São Paulo');

insert into cidade (id, nome, estado_id) values(1, 'Recife', 1);
insert into cidade (id, nome, estado_id) values(2, 'São Paulo', 2);