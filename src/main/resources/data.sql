insert into blogger values (1,21,'Gyula');
insert into blogger values (2,24,'Bogyó');
insert into story (id,title,content,posted,blogger_id) values (1,'teszt cím','tesz tartalom',current_date(),(select id from blogger where name='Gyula'));
insert into story (id,title,content,posted,blogger_id) values (2,'teszt2 cím','teszt2 tartalom2',current_date(),(select id from blogger where name='Gyula'));
insert into story (id,title,content,posted,blogger_id) values (3,'teszt3 cím','teszt3 tartalom3',current_date(),(select id from blogger where name='Bogyó'));
insert into story (id,title,content,posted,blogger_id) values (4,'teszt4 cím','teszt4 tartalom4',current_date(),(select id from blogger where name='Bogyó'));
insert into story (id,title,content,posted,blogger_id) values (5,'szia','szia tartalom',current_date(),(select id from blogger where name='Bogyó'));