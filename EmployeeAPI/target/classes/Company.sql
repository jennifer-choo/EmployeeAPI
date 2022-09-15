DROP DATABASE IF EXISTS company_JennicaM;


CREATE DATABASE IF NOT EXISTS company_JennicaM;

Use company_JennicaM;

show tables;

CREATE TABLE IF NOT EXISTS Employee(
    employee_id smallint unique PRIMARY KEY AUTO_INCREMENT,
    fname varchar(30),
    lname varchar(30),
    postcode varchar(10),
    address varchar(250),
    nin varchar(11) unique,
    bank_account varchar(34) unique,
    starting_salary decimal(11,5),
    isManager bit,
    department enum('SALES', 'HR', 'FINANCE')
);

CREATE TABLE IF NOT EXISTS HREmployee(
    employee_id smallint unique,
    FOREIGN KEY (employee_id) REFERENCES Employee(employee_id)
);

CREATE TABLE IF NOT EXISTS FinanceEmployee(
    employee_id smallint unique,
    FOREIGN KEY (employee_id) REFERENCES Employee(employee_id)
);

CREATE TABLE IF NOT EXISTS SalesEmployees(
    Commission_Rate decimal(2,2),
    Sales_Total decimal(6,2),
    employee_id smallint unique,
    FOREIGN KEY (employee_id) REFERENCES Employee(employee_id)
);

Insert INTO Employee (fname,lname,postcode,address,nin,bank_account,starting_salary,isManager,department)
 Values ("Sarah","Jane","BD5 2WQ","11 Google Lane Birmingham","EM372595B","NL18ABNA1041035373",25000,0,'HR'), 
 ("Marie","Louise","TY6 2PO","78 Maven Lane Birmingham","CX722537C","GB46BARC20035372331392",21000,0,'FINANCE'),
 ("Mark","Jacobs","UN2 2GH","88 Pavael Lane Birmingham","YY490504A","GB74BARC20031868559453",29000,0,'SALES'),
 ("Christian","Jane","PH33 7QA","Ty Cerrig, Prengwyn","AP592799D","GB32BARC20040436982459",25000,0,'HR'),
 ("Anna","Jane","N22 5JD","29 Lower Clarence Road, Norwich","KK980771","GB59BARC20040431199415",45000,1,'HR'),
 ("Marcus","Jane","HR6 8LR","Flat 12, Queens Brewery Court, 46 Moss Lane West, Manchester","YL386963B","GB05BARC20040476115946",21000,0,'FINANCE'),
 ("James","Jane","BS14 9YB","13 Abbeystead Avenue, Bootle","KP704025C","GB67BARC20035317234723",22000,0,'SALES'),
 ("Mave","Jane","BN95 1AA","56 Rathad Ach an Fhuarain, Portree","AP009174A","GB66BARC20031869144992",23000,0,'HR'),
 ("Laura","Jane","CA22 2AY","12 Old Rectory Close, Harpenden","LS326405C","GB18BARC20040491587212",29000,0,'HR'),
 ("Lara","Jane","ML10 6BB","74 Fabis Close, Swadlincote","ET527042C","GB58BARC20037881476639",20000,0,'SALES'),
 ("Ramon","Jane","LA7 7QB","125 Redcliffe Street, Keighley"," NC505501","GB47BARC20032627217115",26000,1,'HR'),
 ("Valienta","Jane","CT19 4QE","22 Waterside Court Office Park, Sheffield","MG445872A","GB96BARC20037893217514",27000,0,'HR'),
 ("Toby","Jane","TN23 5JL","14 Main Road, Wilford","BB064146","GB44BARC20032645666375",28000,0,'FINANCE'),
 ("Jay","Jane","HP19 9UW","Flat 2, Harbour Court, Sea Road, Barton On Sea","GZ162508A","GB68BARC20032685192279",24000,0,'HR'),
 ("Sandra","Jane","LS23 6EL","1 Waterworks Cottages, Dotton","NX265197D","GB93BARC20031854112513",28000,1,'HR'),
 ("Jasmine","Jane","BD99 9XG","Unit 9C Princes Drive Industrial Estate, Kenilworth","GW558870D","GB47BARC20035317879745",26000,0,'SALES'),
 ("Hunter","Jane","SA44 4LU","9 Sutcliffe Avenue, Alderminster","MX351157A","GB16BARC20038095537577",22000,0,'HR');
 
 Select employee_id, department from Employee;
 
Insert into FinanceEmployee(employee_id)
Values (2),(6),(13);

Insert into HREmployee (employee_id)
Values (1),(4),(5),(8),(9),(11),(12),(14),(15),(17);

Insert into SalesEmployees(Commission_Rate ,Sales_Total,employee_id)
Values (1.3,6000.00,3),(1.6,10000.00,7),(1.2,400.00,10),(1.8,5000.00,16);

Select * from SalesEmployees;
 