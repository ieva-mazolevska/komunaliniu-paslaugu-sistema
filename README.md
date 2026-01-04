# komunaliniu-paslaugu-sistema

Java OOP project: community utilities management system



Classes:

\- User (abstract)

\- Admin extends User

\- Manager extends User

\- Resident extends User

\- Community

\- Service

\- Price



Repositories:

\- UserRepository

\- CommunityRepository

\- ServiceRepository

\- PriceRepository



Tables:

users(id, first\_name, last\_name, username, password, role, community\_id)

communities(id, name)

services(id, name, description)

prices(id, community\_id, service\_id, price)



