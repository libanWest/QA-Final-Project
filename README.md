
# Welcome !

This project was done to test myself and also learn the full proccess of creating an application from the ground up, the fruit of my 10 Week intense course at QA training. This Spring-Boot application is based on a **Book Library**.  The main technologies used are **Spring-boot, MySQL, Postman and Junit testing**.


## Summary
I expected this task to be challenging but i planned and broke down the needed tasks to complete this using Agile via Jira. With careful planning all the pieces fell into place.

I was able to complete the back end application with full **CRUD** functionality linked to a database which i was pleased about as my hard work had paid off. I also learnt alot more during the process such as creating entity relationships using **Spring-boot Data JPA**. However the more business logic and functionality that i included, the more testing and integrating that was needed. Overall i believe i achieved this task while also keeping my codebase well organised and readable. 



## Future Improvements

Future improvements can be adding more services that allow users to do custom searches such as organising the books by years, by authors etc. I would like to also add a return date functionality and include a "fine" table for late returns. Finally i would like to create a responsive front end using **Thymeleaf** & **Bootstrap** so that users can access the Book Library on the **web server**.

## Postman & MySQL Screenshots

## Book Table

I  chose to create a **Many to Many**  relationship between my **Book &  Author tables**. This is because a Book can have many Authors, similarly an Author can have many books!.
> **Note:**  This relationship is managed by the join table **Book_authors** .

**Create Book**

![Create a Book](https://user-images.githubusercontent.com/101958815/190919273-bca5d8e6-2511-4da5-a5fa-2fa3fde8ebdb.png)

![enter image description here](https://user-images.githubusercontent.com/101958815/190919274-32ded44b-7b52-41f3-a621-344b09ae946a.png)

**Upadate Book**

![enter image description here](https://user-images.githubusercontent.com/101958815/190919269-85cc44e3-f7dd-4411-95a8-9dc9e9bbf341.png)

![enter image description here](https://user-images.githubusercontent.com/101958815/190919270-2aaac31b-3f73-4305-85c3-7833b4281256.png)

**Get All Books**

![enter image description here](https://user-images.githubusercontent.com/101958815/190919267-6351d5e8-82a9-4feb-94a1-9b30fa5daaf7.png)


**Delete Book**

![enter image description here](https://user-images.githubusercontent.com/101958815/190919275-84baeb0e-3b93-4a3b-8724-e56b1fe8070a.png)

![enter image description here](https://user-images.githubusercontent.com/101958815/190919277-4f66c9cc-ba0c-4aae-9413-8c886695e620.png)

**Add Author to Book**
Since this is a **Many to Many** relationship, one Book can have many authors but that same author can also be added to another Book as shown in below. This relationship will be displayed in the **Book_Authors** table.

![enter image description here](https://user-images.githubusercontent.com/101958815/190919263-2667add8-0912-47dd-8e31-f5a8d4fe0760.png)

![enter image description here](https://user-images.githubusercontent.com/101958815/190919264-eea9512d-d5c6-4b23-9b49-4241c129edba.png)


**Delete Author from Book**

![enter image description here](https://user-images.githubusercontent.com/101958815/190919265-efad85f6-2f9f-4d17-8bd6-31447605873e.png)

![enter image description here](https://user-images.githubusercontent.com/101958815/190919266-189acbc8-a512-4efd-9920-2ced105c51d6.png)

## Users

I created a users table to allow the Borrowing and returning of Books. This also is a **Many to Many** relationship as a **User can borrow multiple books** and a **Book can be be borrowed by many users**. The **copies owned** column in the Book table will decrease and increase as Books are borrowed or returned.
> **Note:** This relationship is managed by the join table **Books_on_loan**. 

**Register User**

![enter image description here](https://user-images.githubusercontent.com/101958815/190919359-1996e00c-5d00-447c-948e-a9375cdbc8ab.png)


![enter image description here](https://user-images.githubusercontent.com/101958815/190919361-2d0be1a8-1e34-4716-a12a-d92b550aa81f.png)

**Update User**

![enter image description here](https://user-images.githubusercontent.com/101958815/190919364-4954f7c5-8529-43dd-b2db-7fac3c84e3dc.png)

![enter image description here](https://user-images.githubusercontent.com/101958815/190919366-971aec6d-52e6-4742-8d35-a6f35c4bb34c.png)

**Get all Users**

![enter image description here](https://user-images.githubusercontent.com/101958815/190919358-fdbca8e5-26bd-4c4e-9a45-4c966a7f27cc.png)

**Delete User**

![enter image description here](https://user-images.githubusercontent.com/101958815/190919362-957fef5c-bb12-4a65-a0ae-38b4cf78744f.png)

![enter image description here](https://user-images.githubusercontent.com/101958815/190919363-f8f87c09-55cc-4372-b672-5a14a24b2302.png)

**Borrow book**
I added this functionality to let users actually **borrow** books and then return them because that what a library main function is. When a User borrows a book the **available copies** of given book will **decrease**. When the book is return the available copies will **increase**, this also happens when a user is **deleted**. This in turn updates the **Books_on_loan** table. 


![enter image description here](https://user-images.githubusercontent.com/101958815/190919368-05b5c464-e42a-45d6-9dd9-335fbeec56d3.png)

![enter image description here](https://user-images.githubusercontent.com/101958815/190919369-3de65ccb-c974-49de-a825-d33a84f61f4e.png)


**Return Book**

![enter image description here](https://user-images.githubusercontent.com/101958815/190919353-b3b4d2a1-2ae9-46ce-a205-7d144b89d616.png)


![enter image description here](https://user-images.githubusercontent.com/101958815/190919356-64099f56-9d3d-42c7-8a3d-371a973597dd.png)

**Available copies increase once returned!**

![enter image description here](https://user-images.githubusercontent.com/101958815/190919355-d6e4ea35-2df0-4df4-9c44-13edacaa9eb7.png)


![enter image description here](https://user-images.githubusercontent.com/101958815/190919357-de02da27-cc76-4de8-ad57-5d5ce5ff29c2.png)

## Authors

**Create Author**

![enter image description here](https://user-images.githubusercontent.com/101958815/190919228-0de928a6-0149-4e49-8ef0-a3eda3697b08.png)

![enter image description here](https://user-images.githubusercontent.com/101958815/190919229-d6a6f9d5-9561-4878-a834-16d8e41ddd91.png)

**Update Book**

![enter image description here](https://user-images.githubusercontent.com/101958815/190919225-824d5b00-391b-4b3e-aecd-fbfc4eb9700b.png)

![enter image description here](https://user-images.githubusercontent.com/101958815/190919227-294b2d16-8aae-427b-af85-108cbdc4100b.png)

**Get all authors**

![enter image description here](https://user-images.githubusercontent.com/101958815/190919267-6351d5e8-82a9-4feb-94a1-9b30fa5daaf7.png)

**Delete Author**

![enter image description here](https://user-images.githubusercontent.com/101958815/190919222-b46db644-312f-4043-9314-416bb51b58ec.png)

![enter image description here](https://user-images.githubusercontent.com/101958815/190919223-8bfb0edf-73c8-4d8f-ad0a-7b25d8442974.png)

# Testing
**Unit tests**

![enter image description here](https://user-images.githubusercontent.com/101958815/190919322-cb6f9edc-dfa8-48f4-8187-a6ba02a4f803.png)

![enter image description here](https://user-images.githubusercontent.com/101958815/190919319-a8bb8a9e-983e-4007-8f59-897ee1f053bb.png)

![enter image description here](https://user-images.githubusercontent.com/101958815/190919321-4ffecd29-9463-4d97-81af-52789db84c97.png)

**Integration tests**

![enter image description here](https://user-images.githubusercontent.com/101958815/190919324-91e6da48-c27b-49c4-91f3-0abe04944534.png)

![enter image description here](https://user-images.githubusercontent.com/101958815/190919318-e5353fc2-e441-4918-bfd0-1bb7da269b9a.png)

![enter image description here](https://user-images.githubusercontent.com/101958815/190919323-c3177b56-dfee-4469-a463-7d1e304fee36.png)

**Test coverage**
The final test coverage was 70%, room for improvement.

![enter image description here](https://user-images.githubusercontent.com/101958815/190919320-074b4733-e2fa-4c43-9e28-b164ada11b1a.png)
