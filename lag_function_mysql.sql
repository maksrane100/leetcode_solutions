-- Find sum, average, min, max salary per department

SELECT first_name, Salary, department_id,
 COUNT(department_id) OVER(PARTITION BY department_id) AS TotalEmployees,
 SUM(Salary) OVER(PARTITION BY department_id) AS TotalSalary,
 AVG(Salary) OVER(PARTITION BY department_id) AS AverageSalary,
 MIN(Salary) OVER(PARTITION BY department_id) AS MinSalary,
 MAX(Salary) OVER(PARTITION BY department_id) AS MaxSalary
FROM 
    employees;
	
SELECT 
    employee_id,
    first_name,
    last_name,
    email,
    job_id,
    hire_date,
    LAG(hire_date,1) OVER (
        PARTITION BY job_id
        ORDER BY hire_date ) as PreviousHireDate
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
    LAG(salary,1) OVER (
        PARTITION BY job_id
        ORDER BY salary ) as PreviousSalary
FROM 
    employees;	