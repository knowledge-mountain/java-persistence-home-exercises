insert into home."user"(email, cognito_username)
values ('plynch@email.com', 'peterlynch');

insert into home.advisor(user_id, "role")
values ((select id
         from home."user"
         where cognito_username = 'peterlynch'), 'senior'::home.advisor_role);

insert into home."user"(email, cognito_username)
values ('jdeere@email.com', 'johndeere');

insert into home.applicant(user_id, firstname, lastname, ssn)
values ((select id
         from home."user"
         where cognito_username = 'johndeere'), 'John', 'Deere', 111);

insert into home.address(applicant_id, city, street, number, zip, apt)
values ((select id
         from home."user"
         where cognito_username = 'johndeere'), 'East Moline', 'Ave', 13, 61244, 1100);

insert into home.phone_number(applicant_id, number, phone_type)
values ((select id
         from home."user"
         where cognito_username = 'johndeere'), '1-844-809-1508', 'work'::home.phone_type);

insert into home.application(applicant_id, advisor_id, amount, app_status, assigned_at)
values ((select id
         from home."user"
         where cognito_username = 'johndeere'),
        (select id
         from home."user"
         where cognito_username = 'peterlynch'), 10000000000.0, 'assigned'::home.application_status, now())
