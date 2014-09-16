INSERT INTO users (id  ,user_enabled ,user_fullname ,user_password ,user_privilege ,user_salt ,user_name )VALUES (1 , '1', 'Kasutaja Nimi', 'parool', 'ROLE_ADMIN', NULL , 'admin');
INSERT INTO tv_channels(id, channel_name, channel_description)VALUES (1, 'Kanal1', 'pikk kirjeldus');
INSERT INTO tv_channels(id, channel_name, channel_description)VALUES (2, 'Kanal2', 'pikk kirjeldus');
INSERT INTO tv_channels(id, channel_name, channel_description)VALUES (3, 'Kanal3', 'pikk kirjeldus');
INSERT INTO programs(id, program_enabled, program_length, program_name, channel_id)VALUES (1, '1', 25, 'programm1', 1);
INSERT INTO programs(id, program_enabled, program_length, program_name, channel_id)VALUES (2, '1', 15, 'programm2', 1);
INSERT INTO programs(id, program_enabled, program_length, program_name, channel_id)VALUES (3, '1', 60, 'programm3', 1);
INSERT INTO programs(id, program_enabled, program_length, program_name, channel_id)VALUES (4, '1', 35, 'programm4', 2);
INSERT INTO programs(id, program_enabled, program_length, program_name, channel_id)VALUES (5, '1', 10, 'programm5', 2);
INSERT INTO programs(id, program_enabled, program_length, program_name, channel_id)VALUES (6, '1', 20, 'programm6', 3);
INSERT INTO starttimes(id, enabled, time, program_id)VALUES (1, '1', '2012-01-22 20:10:00', 1);
INSERT INTO starttimes(id, enabled, time, program_id)VALUES (2, '1', '2012-01-23 20:10:00', 1);
INSERT INTO starttimes(id, enabled, time, program_id)VALUES (3, '1', '2012-01-24 20:10:00', 1);
INSERT INTO starttimes(id, enabled, time, program_id)VALUES (4, '1', '2012-01-25 20:10:00', 1);
INSERT INTO starttimes(id, enabled, time, program_id)VALUES (5, '1', '2012-01-23 20:40:00', 2);
INSERT INTO starttimes(id, enabled, time, program_id)VALUES (6, '1', '2012-12-31 22:00:00', 3);
INSERT INTO starttimes(id, enabled, time, program_id)VALUES (7, '1', '2012-01-02 16:20:00', 4);
INSERT INTO starttimes(id, enabled, time, program_id)VALUES (8, '1', '2012-01-09 16:20:00', 4);
INSERT INTO starttimes(id, enabled, time, program_id)VALUES (9, '1', '2012-01-16 16:20:00', 4);
INSERT INTO starttimes(id, enabled, time, program_id)VALUES (10, '1', '2012-01-23 16:20:00', 4);
INSERT INTO starttimes(id, enabled, time, program_id)VALUES (11, '1', '2012-01-30 16:20:00', 4);
INSERT INTO starttimes(id, enabled, time, program_id)VALUES (12, '1', '2012-02-13 13:45:00', 5);
INSERT INTO starttimes(id, enabled, time, program_id)VALUES (13, '1', '2012-02-15 13:45:00', 5);
INSERT INTO starttimes(id, enabled, time, program_id)VALUES (14, '1', '2012-02-17 13:45:00', 5);
INSERT INTO starttimes(id, enabled, time, program_id)VALUES (15, '1', '2012-02-19 13:45:00', 5);
INSERT INTO starttimes(id, enabled, time, program_id)VALUES (16, '1', '2012-02-21 13:45:00', 5);
INSERT INTO starttimes(id, enabled, time, program_id)VALUES (17, '1', '2012-02-23 13:45:00', 5);
INSERT INTO starttimes(id, enabled, time, program_id)VALUES (18, '1', '2012-01-12 18:00:00', 6);
INSERT INTO starttimes(id, enabled, time, program_id)VALUES (19, '1', '2012-01-12 18:30:00', 6);
INSERT INTO starttimes(id, enabled, time, program_id)VALUES (20, '1', '2012-01-12 19:00:00', 6);
INSERT INTO tags(id, tag_name)VALUES (1, 'lastele');
INSERT INTO tags(id, tag_name)VALUES (2, 'joonis');
INSERT INTO tags(id, tag_name)VALUES (3, 'film');
INSERT INTO tags(id, tag_name)VALUES (4, 'krimi');
INSERT INTO tags(id, tag_name)VALUES (5, 'dokumentaal');
INSERT INTO tags(id, tag_name)VALUES (6, 'huumor');
INSERT INTO tags(id, tag_name)VALUES (7, 'kvaliteet');
INSERT INTO tags_programs(tag_id, program_id)VALUES (1, 2);
INSERT INTO tags_programs(tag_id, program_id)VALUES (2, 1);
INSERT INTO tags_programs(tag_id, program_id)VALUES (3, 3);
INSERT INTO tags_programs(tag_id, program_id)VALUES (4, 5);
INSERT INTO tags_programs(tag_id, program_id)VALUES (5, 4);
INSERT INTO tags_programs(tag_id, program_id)VALUES (6, 5);
INSERT INTO tags_programs(tag_id, program_id)VALUES (7, 1);
INSERT INTO tags_programs(tag_id, program_id)VALUES (7, 2);
INSERT INTO tags_programs(tag_id, program_id)VALUES (7, 3);
INSERT INTO tags_programs(tag_id, program_id)VALUES (7, 4);
INSERT INTO tags_programs(tag_id, program_id)VALUES (7, 5);