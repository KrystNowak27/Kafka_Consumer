insert into client (user_id, first_name, surname, email, balance)
select personality.user_id, personality.first_name, personality.surname, personality.email, personality.balance
from personality
left join client on personality.email = client.email
where client.email is null;
