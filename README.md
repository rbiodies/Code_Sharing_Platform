# <img height="32" width="32" src="https://unpkg.com/simple-icons@v6/icons/springboot.svg" /> Code_Sharing_Platform <img height="32" width="32" src="https://unpkg.com/simple-icons@v6/icons/postman.svg" />
### The objective of this project:
Store all the code snippets that have been uploaded to the program.
### Examples:
<details>
<summary>Example 1: a POST /api/code/new requests with the body</summary>

![](https://user-images.githubusercontent.com/90090114/187080697-3f897a61-0f55-4954-8e7a-495cc12ae99b.png)
![](https://user-images.githubusercontent.com/90090114/187081060-086e40c0-2f0e-4342-8866-c8ef747d8c55.png)
>ID is the unique number of the snippet that helps you access it via the endpoint GET /code/N.
</details>
<details>
<summary>Example 2: a GET /api/code/1 request with the correct id</summary>

![](https://user-images.githubusercontent.com/90090114/187081333-3bc7d26a-f112-46c7-b235-9b0943ad1a2a.png)
</details>
<details>
<summary>Example 3: a GET /api/code/2 request with the correct id</summary>

![](https://user-images.githubusercontent.com/90090114/187081364-9633f141-599b-42be-9916-41da345195ec.png)
</details>
<details>
<summary>Example 4: a GET /api/code/3 request, a wrong id number</summary>

![](https://user-images.githubusercontent.com/90090114/187081392-4eff3bc8-5977-4d6f-b30e-6c2e1f15813d.png)
</details>
<details>
<summary>Example 5: a GET /api/code/latest request</summary>

![](https://user-images.githubusercontent.com/90090114/187081469-100426b2-6464-492a-9b93-17f06651dc09.png)
>Return a JSON array with 10 most recently uploaded code snippets sorted from the newest to the oldest.
</details>
<details>
<summary>Example 6: a GET /code/latest request</summary>

![](https://user-images.githubusercontent.com/90090114/187081597-3ebebc48-2091-480d-94d5-414b0377853b.png)
>Use the following dependency in the build.gradle file to be able to use FreeMarker:
>```
>implementation 'org.springframework.boot:spring-boot-starter-freemarker'
>```
>Apache FreeMarker™ is a template engine: a Java library to generate text output (HTML web pages, e-mails, configuration files, source code, etc.).
</details>
<details>
<summary>Example 7: a GET /code/new request</summary>

![](https://user-images.githubusercontent.com/90090114/187081787-eed94929-09de-439f-ae67-64d4c8b32e83.png)
![](https://user-images.githubusercontent.com/90090114/187081791-cf9736f8-660d-444f-a828-920b079f7b1e.png)
</details>
<details>
<summary>Example 8: a GET /code/latest request</summary>

![](https://user-images.githubusercontent.com/90090114/187081873-37d07a7d-7d9c-47b3-af7c-34e8cf52e652.png)
</details>
