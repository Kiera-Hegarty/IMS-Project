Jira board link - https://kiera-hegarty.atlassian.net/jira/software/projects/KH/boards/3

Coverage: 64.5%

**IMS Project**

The aim of this project is to create an inventory management system by using: 
**Java 
Maven 
JUnit 
Mockito 
MySQL 
Jira**

**Getting Started**
These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

**Prerequisites**
Software Installations for this project:

MySQL: https://dev.mysql.com/downloads/windows/installer/8.0.html
Java: https://www.oracle.com/java/technologies/javase/jdk14-archive-downloads.html
Eclipse: https://www.eclipse.org/downloads/
Maven: https://maven.apache.org/download.cgi?Preferred=ftp://ftp.osuosl.org/pub/apache/

**Installing**
A step by step series of examples that tell you how to get a development env running;

First, install and set up all software.

Then open MySQL Workbench to create a database. Select the local database instance to enter credentials. In the query section make a database called ims; CREATE DATABASE ims.

To run the IMS system go to the directory where the pom.xml file is located; Run command: mvn clean package This will create a directory 'target' which will contain a jar file. Run the jar file by navigating to target file and running the following command: java -jar ims-jar-with-dependencies.jar

**Running the tests**

**Integration Tests**

JUnit

	@Test
	public void itemTestUpdate() {
		final Item updated = new Item(1L,"Hunger Games", 35, 10);
		assertEquals(updated, DAO.update(updated));
	}
	
**Unit Tests**

Mockito

	@Test
	public void itemTestCreate() {
		final String I_NAME = "The Giver";
		final int STOCK = 25, PRICE = 10;
		final Item created = new Item(I_NAME, STOCK, PRICE);

		Mockito.when(utils.getString()).thenReturn(I_NAME);
		Mockito.when(utils.getInt()).thenReturn(STOCK, PRICE);
		Mockito.when(dao.create(created)).thenReturn(created);
		assertEquals(created, controller.create());
		Mockito.verify(utils, Mockito.times(1)).getString();
		Mockito.verify(utils, Mockito.times(2)).getInt();
		Mockito.verify(dao, Mockito.times(1)).create(created);
	}
	
	
**Deployment**
CRUD functions work. However, cannot add individual items to to order (attempted code commented at bottom of OrderControllers class).

**Built With**
Maven - Dependency Management
Versioning
We use SemVer for versioning.

**Authors**
* **Chris Perrins** - *Initial work* - christophperrins
* **Kiera Hegarty** - *Continued to build on intital work* - Kiera-Hegarty

**License**

This project is licensed under the MIT license - see the LICENSE.md file for details

For help in Choosing a license

**Acknowledgments**
Chris Perrins who created the inital project
