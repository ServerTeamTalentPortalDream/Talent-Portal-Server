	CREATE TABLE cognizant_projects.project(
	competency VARCHAR(20) NOT null,
	customer VARCHAR(50) NOT null,
	details VARCHAR(100),
	project_id SERIAL PRIMARY KEY,
	project_location VARCHAR(50) NOT null,
	project_name VARCHAR(50) NOT null,
	start_date DATE DEFAULT NOW(),
	end_date DATE,
	supervisor VARCHAR(35) NOT null,
	supervisor_id INT
)