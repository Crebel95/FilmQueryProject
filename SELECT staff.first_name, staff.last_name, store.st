SELECT staff.first_name, staff.last_name, store.store_id, store.manager_id
FROM staff
JOIN store
ON staff.store_id = store.id;
--------- Getting all employees first, last names

SELECT staff.first_name, staff.last_name, store.store_id, store.manager_id
FROM staff
JOIN store
ON staff.id = store.manager_id;
--------------------------------------------------------------------
SELECT film.*
FROM film JOIN film_actor ON film.id = film_actor.film_id WHERE film_actor.actor_id = 