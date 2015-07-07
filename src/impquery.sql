SELECT ses.SessionId,ur.SessionId,tr.TrainerName,tr.TrainerId FROM userreview ur
LEFT OUTER JOIN sessions1 ses ON ur.Sessionid=ses.SessionId
LEFT OUTER JOIN trainers tr ON ses.TrainerId=tr.TrainerId;



SELECT * FROM  feedback.usersecuredata usd  INNER JOIN feedback.securityquestions sq on usd.Sid=sq.id And usd.Answer="kurnool" where usd.Empid='6192' 



salting passwords in java:

http://java.dzone.com/articles/storing-passwords-java-web


String to date comparison:
http://www.mkyong.com/java/how-to-convert-string-to-date-java/


saving image in database using hibernate:

http://www.mkyong.com/hibernate/hibernate-save-image-into-database/

enlarging image on button click:

http://lokeshdhakar.com/projects/lightbox2/

com.mysql.jdbc.MysqlDataTruncation: Data truncation: Data too long for column 'image' at row 1

Fix:

http://stackoverflow.com/questions/21522875/data-truncation-data-too-long-for-column-logo-at-row-1

Use following data types as per your need

TINYBLOB   :     maximum length of 255 bytes  
BLOB       :     maximum length of 65,535 bytes  
MEDIUMBLOB :     maximum length of 16,777,215 bytes  
LONGBLOB   :     maximum length of 4,294,967,295 bytes  
