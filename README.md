# SupplyChainManagementSystem

## //Project description//

This project aims to smoothen the supply chain management process by closely monitoring the dealers 
and clients and continually tracking the products through the different points in the supply chain

Application will automate the system of communication between the management or admin, dealers, and clients of the company. There are three modules in this application:
* Admin module – The Admin uses this module to check information on the manufactured products, newly launched products, and products that must be delivered to the clients.
* Dealer module – This module keeps track of all the essential information concerning the dealers, particularly the record of items. Dealers can generate and update the item list for a product using this module.
* Client module – The client uses this module to provide the necessary specifications of a product. The client feedback is processed through this module and forwarded to the Admin.

The dealers usually create a list of items as per the product information provided to them, after which the manufacturer selects the materials that best fit the specifications given by the client.

Then, the selected list of items is forwarded to the inventory department for processing, after which the manufacturing begins. Once the production is complete, the accounts department calculates the raw materials’ costs and manufacturing costs to generate the total bill. Finally, the product, along with the invoice, is shipped to the client. The client is free to offer feedback on the received product (Commenting).


## Endpoints (Main)

LOGIC ENDPOINTS (+5 method) <br/><br>
POST http://localhost:8080/Java_final_war_exploded/SupplyChainManagementSystem/LOGIC/Client/confirmOrder/save  
PUT http://localhost:8080/Java_final_war_exploded/SupplyChainManagementSystem/LOGIC/Admin/confirmOrder/update/confirm  
GET http://localhost:8080/Java_final_war_exploded/SupplyChainManagementSystem/LOGIC/Admin/confirmOrder/getById/check_confirm/2  
GET http://localhost:8080/Java_final_war_exploded/SupplyChainManagementSystem/LOGIC/Admin/doneOrder/getById/check_Component/2 
PUT http://localhost:8080/Java_final_war_exploded/SupplyChainManagementSystem/LOGIC/Client/orders/update/feedback  

Additional-LOGIC ENDPOINTS (+2 method) <br/><br>
PUT http://localhost:8080/Java_final_war_exploded/SupplyChainManagementSystem/LOGIC/Admin/doneOrder/update/done <br/>
GET http://localhost:8080/Java_final_war_exploded/SupplyChainManagementSystem/LOGIC/Admin/doneOrder/getById/check_done/2


## Project logic
![Logic-description (in Paper)](https://user-images.githubusercontent.com/87764579/180735067-fed0d6c1-b644-4e9c-bec8-65dd8b70c669.jpeg)

## Project Design (Not Front-End)
![1 (Client-Page)](https://user-images.githubusercontent.com/87764579/180738408-388ec844-783d-45fe-b88f-900b33914c1d.png)
![2 (Admin-Page)](https://user-images.githubusercontent.com/87764579/180738425-7e52de15-11ff-4660-8b96-33ce52a5d3f0.png)
![3 (Dealer-Page)](https://user-images.githubusercontent.com/87764579/180738435-0a946777-cffa-4194-be2b-8d4adfd1e985.png)
