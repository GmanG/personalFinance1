CREATE TABLE IF NOT EXISTS USER(
	ID BIGINT NOT NULL AUTO_INCREMENT,
	Email VARCHAR(40) NOT NULL,
	Pass VARCHAR(40) NOT NULL,
	Created DATETIME NOT NULL,
	Updated DATETIME NOT NULL, PRIMARY KEY(ID)
);
CREATE TABLE IF NOT EXISTS Categorie(
	ID BIGINT NOT NULL AUTO_INCREMENT,
	Name VARCHAR(40) NOT NULL,
	UserID BIGINT, FOREIGN KEY(UserID) REFERENCES USER(id), PRIMARY KEY(ID)
);
CREATE TABLE IF NOT EXISTS CategorieType(
	ID BIGINT NOT NULL AUTO_INCREMENT,
	Name VARCHAR(50) NOT NULL,
	UserID BIGINT, FOREIGN KEY(UserID) REFERENCES USER(id), PRIMARY KEY(ID)
);
CREATE TABLE IF NOT EXISTS Balance(
	ID BIGINT NOT NULL AUTO_INCREMENT,
	UserID BIGINT,
	CategorieID BIGINT,
	TypeID BIGINT, SUM DECIMAL(10,2),
	StatusID BIGINT, FOREIGN KEY(UserID) REFERENCES USER(id), FOREIGN KEY(CategorieID) REFERENCES Categorie(id), FOREIGN KEY(typeID) REFERENCES CategorieType(id), FOREIGN KEY (StatusID) REFERENCES balancestatus(ID), PRIMARY KEY(ID)
);

create table balanceStatus (
	ID BIGINT NOT NULL AUTO_INCREMENT,
	StatusName VARCHAR(20)  NOT NULL,
	PRIMARY KEY(id)
);


@NamedQueries ({
				@NamedQuery(
							name = "findAllUserCategory",
							query = "select cat from Categorie cat where cat.user = :user or cat.user is null"
						),
				@NamedQuery(
							name = "findAllUserCategory1",
							query = "select cat from Categorie cat where cat.user is null "
						),
				@NamedQuery(
							name = "findOneCategoryBYID",
							query = "select cat from Categorie cat where cat.name = :name"
						),
})


@NamedQueries ({ 
			@NamedQuery(name = "findLastFiveTransaction",
				query = "SELECT b FROM Balance b, Categorietype c " +
						"WHERE b.user = :user and c.user = :user and b.categorietype = c"),
			@NamedQuery (name = "getAll",
						query = "Select b from Balance b")
//})
//@SqlResultSetMappings ({
//						@SqlResultSetMapping (name = "BalanceWithCategoryType",
//						entities = {@EntityResult (entityClass = Balance.class)
//									@EntityResult (entityClass = Categorietype.class)
						}
						)
						
						
						@NamedQueries ({
			@NamedQuery
			(name = "getUserByEmail",
	 		 query = "select u from User u where u.email = :email"),
			@NamedQuery 
			(name ="findUserByEmailAndPass",
			 query = "select u from User u where u.email = :email and u.pass = :pass"),
			 @NamedQuery
				(name = "getUsers",
		 		 query = "select u from User u"),
			
})

@NamedQueries ({
				@NamedQuery(
							name = "getCategoryTypeByUser",
							query = "select o from Categorietype o where o.user = :user or o.user is null"
						),
				@NamedQuery(
							name = "getCategoryTypeByName",
							query = "select catType from Categorietype catType where catType.name = :name"
						),
})