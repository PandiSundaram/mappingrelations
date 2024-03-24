**ASSOCIATION MAPPING**

 non collection - 1 ... 1 & * ...1
 collection     - 1 ... * & *... *

 Ref : https://www.youtube.com/watch?v=LOaaOSJL3s8&t=361s

Tables are connected using PK and FK

one table PL with other table FK


1. Create two tables
2. Creaate HAS-A variable
3. Checking collection or non collection
4. Apply Multiplicity annotation
   @ManyToOne, @OneToMany, @ManyToMany, @OneToOne,
   Note: always fk colum goes with many table
5. Add Joincoloum / JoinTable(only for manytomany)

**infinite fetch issue with bidirection relationship**

solutioin 1:  @JsonManagedReference @JsonBackReference 
solutioin 2:  If we create a response model before sending it back we can fix this issue

**N+1 issue when we have oneTomany fetchAll lazyloading**

solution :  Inner join or left join solve the problem


@ManyToOne    *(Student)...1(Book)

    Class Student{
       Integer sid;
       String  sname;
       @ManyToOne
       @JoinColumn(name="bfk")
       Set<Book> bob;

     


**SQL QURRIES**

**Easy:**
1. select distinct country from customers  -> return unique country value
2. select count(country) from customers -> return no of countries 

  where clause with between and like
4. select price from order where price between 100 and 200
5. select * from customer where country="berlin" and (name like '%s' or name like "%r)
6. select * from customer where not name = "pandi"


  order by
5. select * from customers order by name desc
6. select * from customers order by price

Insert

7. insert into (name, city, pincode) values ("pandi","tnj","614019)

Update

8. update customers set city="tnj" where customername="pandi"

Limit

9. select * from customers where city="tnj" limit 3
10. select sum(price) from products;
11. select avg(price) from products;
12. select max(price) from products;
13. select min(price) from products;
14. select sum(quantity * 10) from products
15. select sum(qunatity * price) from orders left join items on orders.itemid=items.itemid
16. select * from products where price > (select avg(price) from products)
17. select country from customers where country like 'startingletter%' -- starwith
18. select country from customers where country like '%a' -- endswith
19. select country from customers where country like  '%a%' -- contains
20. select country from customer where country like '_o%' -- starts w

find 2 or nth highest salary

21. select price from products order by desc limit 1 offset 1 -> Second highest salary (offset will take the data from 0,1,2 index, limit will give howmuch recore you want) 



Database indexing

  create index myindex on customers(employeeName)

DBMS creates data pages has header (top)-holdes datapage number like datapage-1, rows (middle) -> actual data in the form of rows and offset (footer) -> hold index to point rows with 8kb of memory
with will stores approximately 120 rows

Rdms manage datapage, but data page point to physical location of the data which is data block

when we search for a data, the data page will load datablock and read the data if data is not finding, it will go the next datapage with datablock

Index
   DBMS using b+ kind of binary tree to manage indexes and datapages for faster retrieval
if we create index, dbms create b+ tree to manage using sorting order

 primary -cluster
 secondary - non cluster
 composite

Clustered index
  By default dbms create index for primary key which shoule be not null and unique, if we does 
not specify primary key, DBMS creates autoincrement key internall to manage index

Seconday index:
  creates equvalent b+ tree for the column which is selected for column index

 while creating index things to be considered
  1. Should have more rows like more than 20K
  2. should not have more update operation because index update also required
  3. Column which we query more often

How index query is perfomed

   1. When we search for particular data which is present in index, first it will find the index page

2. B+ traversal happen to find datapage
3. once data page found, will find out data block 



   Better performace 

1. Avoid * instead we can select required fields
2. Avoid distinct query beacuse it intens using group by will reduce query performance
3. try to avoid wildcard queries,joins,subqueries,group by, in if it is not really required
4. try using where instead of having
5. use indexes
6. use approriotate datatypes
7. we can use query optimization tools to see where index required which query has to be rewritten
ex: sql querry optimizer


https://medium.com/learning-sql/12-tips-for-optimizing-sql-queries-for-faster-performance-8c6c092d7af1



https://www.youtube.com/watch?v=zGYLUogRe-M&list=PLqM7alHXFySGweLxxAdBDK1CcDEgF-Kwx&index=9

https://www.youtube.com/watch?v=W2Mq5JER2sM&list=PLGRIaa4wmIrDsmKV5pmPxxBPbF5yig-bQ&index=30


