create table Altendis_Form (
	formId LONG not null primary key,
	groupId LONG,
	createDate DATE null,
	nom VARCHAR(75) null,
	prenom VARCHAR(75) null,
	telephone VARCHAR(16) null,
	email VARCHAR(75) null,
	comment_ STRING null
);