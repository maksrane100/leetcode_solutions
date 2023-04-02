SELECT 
    employee_id,
    first_name,
    last_name,
    email,
    job_id,
    hire_date,
    avg(salary) OVER (
        PARTITION BY job_id) 
FROM 
    employees;
	
SELECT 
    employee_id,
    first_name,
    last_name,
    email,
    job_id,
    hire_date,
    LEAD(hire_date,2) OVER (
        PARTITION BY job_id
        ORDER BY hire_date ) as NextHireDate
FROM 
    employees;

SELECT 
    employee_id,
    first_name,
    last_name,
    email,
    job_id,
    hire_date,
    salary,
    LEAD(salary,1) OVER (
        PARTITION BY job_id
        ORDER BY salary ) as NextSalary
FROM 
    employees;