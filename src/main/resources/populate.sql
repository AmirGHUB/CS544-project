use team6;


INSERT INTO credentials(username,password,verifypassword,enabled) VALUES ('guest','$2a$10$0.ESlGysrPaiW5HaapKwoehzWt5AibgbPPOvMhDv8D6H26QQ/CwhS','$2a$10$0.ESlGysrPaiW5HaapKwoehzWt5AibgbPPOvMhDv8D6H26QQ/CwhS', TRUE);
INSERT INTO credentials(username,password,verifypassword,enabled) VALUES ('admin','$2a$10$S/wlXEo/APzf.Sn1cO2p4.V12EJmaw.uzrHelMvkpuahjmHWnSafe','$2a$10$S/wlXEo/APzf.Sn1cO2p4.V12EJmaw.uzrHelMvkpuahjmHWnSafe', TRUE);

INSERT INTO authorities (ID,username, authority) VALUES (1,'guest', 'ROLE_USER');
INSERT INTO authorities (ID,username, authority) VALUES (2,'admin', 'ROLE_ADMIN');
INSERT INTO authorities (ID,username, authority) VALUES (3,'admin', 'ROLE_USER');


INSERT INTO `users` VALUES (1,'cg@gmail.com','Curious','M','George',"guest");
INSERT INTO `users` VALUES (2,'BigAl@gmail.com','Allen','M','Rench',"admin");


SET sql_safe_updates = 0;
UPDATE hibernate_sequence SET next_val = 20;
SET sql_safe_updates = 1;