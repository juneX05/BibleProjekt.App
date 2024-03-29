CREATE TABLE IF NOT EXISTS `books` (`id`	integer AUTO_INCREMENT NOT NULL UNIQUE, `title_short`	text NOT NULL UNIQUE, `title_full`	text NOT NULL UNIQUE, `abbreviation`	text NOT NULL UNIQUE, `category`	text NOT NULL, `otnt`	text NOT NULL, `chapters` int, PRIMARY KEY (`id`));
INSERT INTO books VALUES(1,'Genesis','The First Book of Moses Called Genesis','Gen.','Law','OT',50);
INSERT INTO books VALUES(2,'Exodus','The Second Book of Moses Called Exodus','Ex.','Law','OT',40);
INSERT INTO books VALUES(3,'Leviticus','The Third Book of Moses Called Leviticus','Lev.','Law','OT',27);
INSERT INTO books VALUES(4,'Numbers','The Fourth Book of Moses Called Numbers','Num.','Law','OT',36);
INSERT INTO books VALUES(5,'Deuteronomy','The Fifth Book of Moses Called Deuteronomy','Deut.','Law','OT',34);
INSERT INTO books VALUES(6,'Joshua','The Book of Joshua','Josh.','Old Testament Narrative','OT',24);
INSERT INTO books VALUES(7,'Judges','The Book of Judges','Judg.','Old Testament Narrative','OT',21);
INSERT INTO books VALUES(8,'Ruth','The Book of Ruth','Ruth','Old Testament Narrative','OT',4);
INSERT INTO books VALUES(9,'1 Samuel','The First Book of Samuel','1 Sam.','Old Testament Narrative','OT',31);
INSERT INTO books VALUES(10,'2 Samuel','The Second Book of Samuel','2 Sam.','Old Testament Narrative','OT',24);
INSERT INTO books VALUES(11,'1 Kings','The First Book of Kings','1 Kings','Old Testament Narrative','OT',22);
INSERT INTO books VALUES(12,'2 Kings','The Second Book of Kings','2 Kings','Old Testament Narrative','OT',25);
INSERT INTO books VALUES(13,'1 Chronicles','The First Book of Chronicles','1 Chron.','Old Testament Narrative','OT',29);
INSERT INTO books VALUES(14,'2 Chronicles','The Second Book of Chronicles','2 Chron.','Old Testament Narrative','OT',36);
INSERT INTO books VALUES(15,'Ezra','The Book of Ezra','Ezra','Old Testament Narrative','OT',10);
INSERT INTO books VALUES(16,'Nehemiah','The Book of Nehemiah','Neh.','Old Testament Narrative','OT',13);
INSERT INTO books VALUES(17,'Esther','The Book of Esther','Est.','Old Testament Narrative','OT',10);
INSERT INTO books VALUES(18,'Job','The Book of Job','Job','Wisdom Literature','OT',42);
INSERT INTO books VALUES(19,'Psalms','The Book of Psalms','Ps.','Wisdom Literature','OT',150);
INSERT INTO books VALUES(20,'Proverbs','The Book of Proverbs','Prov.','Wisdom Literature','OT',31);
INSERT INTO books VALUES(21,'Ecclesiastes','The Book of Ecclesiastes','Eccles.','Wisdom Literature','OT',12);
INSERT INTO books VALUES(22,'Song of Solomon','Song of Solomon','Song','Wisdom Literature','OT',8);
INSERT INTO books VALUES(23,'Isaiah','The Book of Isaiah','Isa.','Major Prophets','OT',66);
INSERT INTO books VALUES(24,'Jeremiah','The Book of Jeremiah','Jer.','Major Prophets','OT',52);
INSERT INTO books VALUES(25,'Lamentations','The Book of Lamentations','Lam.','Major Prophets','OT',5);
INSERT INTO books VALUES(26,'Ezekiel','The Book of Ezekiel','Ezek.','Major Prophets','OT',48);
INSERT INTO books VALUES(27,'Daniel','The Book of Daniel','Dan.','Major Prophets','OT',12);
INSERT INTO books VALUES(28,'Hosea','The Book of Hosea','Hos.','Minor Prophets','OT',14);
INSERT INTO books VALUES(29,'Joel','The Book of Joel','Joel','Minor Prophets','OT',3);
INSERT INTO books VALUES(30,'Amos','The Book of Amos','Amos','Minor Prophets','OT',9);
INSERT INTO books VALUES(31,'Obadiah','The Book of Obadiah','Obad.','Minor Prophets','OT',1);
INSERT INTO books VALUES(32,'Jonah','The Book of Jonah','Jonah','Minor Prophets','OT',4);
INSERT INTO books VALUES(33,'Micah','The Book of Micah','Mic.','Minor Prophets','OT',7);
INSERT INTO books VALUES(34,'Nahum','The Book of Nahum','Nah.','Minor Prophets','OT',3);
INSERT INTO books VALUES(35,'Habakkuk','The Book of Habakkuk','Hab.','Minor Prophets','OT',3);
INSERT INTO books VALUES(36,'Zephaniah','The Book of Zephaniah','Zeph.','Minor Prophets','OT',3);
INSERT INTO books VALUES(37,'Haggai','The Book of Haggai','Hag.','Minor Prophets','OT',2);
INSERT INTO books VALUES(38,'Zechariah','The Book of Zechariah','Zech.','Minor Prophets','OT',14);
INSERT INTO books VALUES(39,'Malachi','The Book of Malachi','Mal.','Minor Prophets','OT',4);
INSERT INTO books VALUES(40,'Matthew','The Gospel According to Matthew','Matt.','New Testament Narrative','NT',28);
INSERT INTO books VALUES(41,'Mark','The Gospel According to Mark','Mark','New Testament Narrative','NT',16);
INSERT INTO books VALUES(42,'Luke','The Gospel According to Luke','Luke','New Testament Narrative','NT',24);
INSERT INTO books VALUES(43,'John','The Gospel According to John','John','New Testament Narrative','NT',21);
INSERT INTO books VALUES(44,'Acts','The Acts of the Apostles','Acts','New Testament Narrative','NT',28);
INSERT INTO books VALUES(45,'Romans','The Epistle of Paul to the Romans','Rom.','Pauline Epistles','NT',16);
INSERT INTO books VALUES(46,'1 Corinthians','The First Epistle of Paul to the Corinthians','1 Cor.','Pauline Epistles','NT',16);
INSERT INTO books VALUES(47,'2 Corinthians','The Second Epistle of Paul to the Corinthians','2 Cor.','Pauline Epistles','NT',13);
INSERT INTO books VALUES(48,'Galatians','The Epistle of Paul to the Galatians','Gal.','Pauline Epistles','NT',6);
INSERT INTO books VALUES(49,'Ephesians','The Epistle of Paul to the Ephesians','Eph.','Pauline Epistles','NT',6);
INSERT INTO books VALUES(50,'Philippians','The Epistle of Paul to the Philippians','Phil.','Pauline Epistles','NT',4);
INSERT INTO books VALUES(51,'Colossians','The Epistle of Paul to the Colossians','Col.','Pauline Epistles','NT',4);
INSERT INTO books VALUES(52,'1 Thessalonians','The First Epistle of Paul to the Thessalonians','1 Thess.','Pauline Epistles','NT',5);
INSERT INTO books VALUES(53,'2 Thessalonians','The Second Epistle of Paul to the Thessalonians','2 Thess.','Pauline Epistles','NT',3);
INSERT INTO books VALUES(54,'1 Timothy','The First Epistle of Paul to Timothy','1 Tim.','Pauline Epistles','NT',6);
INSERT INTO books VALUES(55,'2 Timothy','The Second Epistle of Paul to Timothy','2 Tim.','Pauline Epistles','NT',4);
INSERT INTO books VALUES(56,'Titus','The Epistle of Paul to the Titus','Titus','Pauline Epistles','NT',3);
INSERT INTO books VALUES(57,'Philemon','The Epistle of Paul to the Philemon','Philem.','Pauline Epistles','NT',1);
INSERT INTO books VALUES(58,'Hebrews','The Epistle to the Hebrews','Heb.','General Epistles','NT',13);
INSERT INTO books VALUES(59,'James','The General Epistle of James','James','General Epistles','NT',5);
INSERT INTO books VALUES(60,'1 Peter','The First Epistle of Peter','1 Pet.','General Epistles','NT',5);
INSERT INTO books VALUES(61,'2 Peter','The Second Epistle of Peter','2 Pet.','General Epistles','NT',3);
INSERT INTO books VALUES(62,'1 John','The First Epistle of John','1 John','General Epistles','NT',5);
INSERT INTO books VALUES(63,'2 John','The Second Epistle of John','2 John','General Epistles','NT',1);
INSERT INTO books VALUES(64,'3 John','The Third Epistle of John','3 John','General Epistles','NT',1);
INSERT INTO books VALUES(65,'Jude','The Epistle of Jude','Jude','General Epistles','NT',1);
INSERT INTO books VALUES(66,'Revelation','The Book of Revelation','Rev.','Apocalyptic Epistle','NT',22);