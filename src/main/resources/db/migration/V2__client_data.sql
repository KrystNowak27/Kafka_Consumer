INSERT INTO client (user_id, first_name, surname, email, balance)
SELECT personality.user_id, personality.first_name, personality.surname, personality.email, personality.balance
FROM personality
LEFT JOIN client ON personality.email = client.email
WHERE client.email IS NULL;
