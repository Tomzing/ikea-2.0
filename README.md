# ikea-2.0
Finally a good competitor.

                         ____
                        /    \
                       /______\
                          ||
           /~~~~~~~~\     ||    /~~~~~~~~~~~~~~~~\
          /~ () ()  ~\    ||   /~ ()  ()  () ()  ~\
         (_)========(_)   ||  (_)==== ===========(_)
          I|_________|I  _||_  |___________________|


In order to make requests, run the project. The URL is localhost:8080.
Calls on the REST API:

1. Get order: localhost:8080/{id}
2. Create order: localhost:8080/createOrder
As post request, you have to send a list of product_ids to the API that the order is associated with.

{
    "productList": [
        {
            "id": 1
        }
    ]
}

In order to check out the database:
URL: "localhost:8080/h2"
JDBC URL: "jdbc:h2:mem:memDb"
username: "sa"


Proposed UML: https://i.imgur.com/s705bNt.png