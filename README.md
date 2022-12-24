# Spring-Boot-Bank-Service-REST-GRAPHQL

## Project Structure :

<img width="348" alt="Screen Shot 2022-12-24 at 9 07 40 PM" src="https://user-images.githubusercontent.com/84875875/209449790-09c852c0-0a71-4208-9946-70a7d71d74e1.png">

## REST :

<img width="892" alt="Screen Shot 2022-12-24 at 9 02 09 PM" src="https://user-images.githubusercontent.com/84875875/209449688-2d5c33c6-140a-40f1-8bef-799d63b74094.png">

![screencapture-localhost-8081-swagger-ui-index-html-2022-12-24-19_34_54](https://user-images.githubusercontent.com/84875875/209449598-1b432629-96a0-4625-a220-abca06dec30e.png)

## GRAPHQL :

### Schema : 

```
type Query {
    accounts : [BankAccount],
    bankAccountById (id : String) : BankAccount
    customers : [Customer]
}
type Mutation {
    addBankAccount(bankAccount : BankAccountDTO) : BankAccountMutation
    updateBankAccount(bankAccount : BankAccountDTO, id : String) : BankAccountMutation
    deleteBankAccount(id: String) : String
}

type BankAccountMutation {
    id : String,
    createdAt : Int,
    balance : Float,
    currency : String,
    accoutType : String,
    customerDTO : Customer
}

type BankAccount {
    id : String,
    createdAt : Int,
    balance : Float,
    currency : String,
    accoutType : String,
    customer : Customer
}

type Customer {
    id : Float,
    name : String
    bankAccounts : [BankAccount]
}

input BankAccountDTO {
    balance : Float,
    currency : String,
    accoutType : String,
    customerDTO : CustomerDTO
}

input CustomerDTO {
    id : Float
}
```

### GraphiQL :

<img width="1440" alt="Screen Shot 2022-12-24 at 7 30 03 PM" src="https://user-images.githubusercontent.com/84875875/209449637-8cba4ce4-1b72-45b9-b6f8-7cd7c8152d36.png">
<img width="1440" alt="Screen Shot 2022-12-24 at 7 30 10 PM" src="https://user-images.githubusercontent.com/84875875/209449639-3494ef1f-bcef-4881-8396-12da4896df9a.png">
<img width="1440" alt="Screen Shot 2022-12-24 at 7 31 34 PM" src="https://user-images.githubusercontent.com/84875875/209449641-8bee53d4-257d-4e3b-95a2-d622479563d7.png">
<img width="1440" alt="Screen Shot 2022-12-24 at 7 32 42 PM" src="https://user-images.githubusercontent.com/84875875/209449642-af17a01c-3096-4a6d-ab41-aa2dcb1f445f.png">
<img width="1440" alt="Screen Shot 2022-12-24 at 7 33 46 PM" src="https://user-images.githubusercontent.com/84875875/209449643-4ff5fffb-8681-4583-8b1e-a2effeee743b.png">
<img width="1440" alt="Screen Shot 2022-12-24 at 7 33 54 PM" src="https://user-images.githubusercontent.com/84875875/209449644-6de7cd4b-dc16-4e13-99f2-4b6beb24bd2b.png">
