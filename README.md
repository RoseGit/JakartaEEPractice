# JakartaEEPractice
Based on this book 
![image](https://github.com/user-attachments/assets/716c671a-aa3e-4787-aabc-03b4cbb5c55f)

please visit the Web Site https://www.murach.com/


WEB-INF usually, this folder contains the web.xml file
        It is used to configure servlets and other components that the application has. 
        This directory is not accessible directly from the web. 

META-INF Contains the context.xml file 
         This file can be used to configure the application context.

Chapter 02: 
        A quick look at Servlets
         It shows in a general way how a JSP works. It also takes a look at the MVC pattern where business objects are defined as a model and data objects are generally persisted as a database using generally DAO's.

        An HTML defines the content of a Web page and CSS files define the style of those components.

        The use and configuration of u servlet is shown, which is a type of special Java class that runs on the server and processes dynamic web pages for the application.

        A Java Bean only provides get and set methods and must implement serializable as well as not have a constructor with arguments.

        A JSP page consists of using special Java tags and allows the use of tags called Expression Languages ​​that are embedded within the HTML code.

Chapter 04
        A quick look at html and css emphasizing that html should be used for content and structure and css to format the page

        To add an external style sheet to a web page, a link must be indicated in the head section of the html document indicating where the style sheet is located.

        HTML5 semantics include header, section, nav, aside and footer elements so applying the CSS makes it easier

        A CSS rule consists of one or more rules and each rule consists of a property name and values.

        An HTML Form contains one or more controls such as text boxes, check boxes, radio buttons, combo boxes, etc. 
        Within the form it must contain a submit button that calls a jsp or servlet when the user clicks, if necessary there can be more forms

Chapter 05
        The use of servlets is shown in a more in-depth way
        A servlet is a Java class that extends the HttpServlet class and runs within a servlet container such as Tomcat

        When you write servlets you tipically override doGet and doPost methods to provide the processing that's required.

        After you use the setContentType method of the response object to set the content type of the responses that's returned to the browser
        We use getWriter method to create a PrinterWriter object. Then we can use the println and print methods to send an HTML back to the browser.

        When we use the Http Get method to pass parameters to a JSP the browser display the parameters in its url.
        When we use the Http Post method the browser doesn't display these parameters

        Within a servlet's doGet or doPost method we can use the getParameter and getParameterValues methods  of the request object to get the parameter values from the request

        We can use the web.xml file to provide custom error pages for specifica Java exceptions or for Http status codes

        We can use the web.xml file or @WebServlet annotation to provide initialization parameters that apply  to the entire application or to specific servlets

        Since instance variables in a servlet are not thread-safe and can result in serious problems, we should never use instance variables un a servlet.

Chapter 07
        Http os a stateless protocol, web applications must provide for session tracking. 
        That way, an application is able to relate each request to a specific browser and to the data for that session.

        To provide for session tracking, Java creates one session object for each browser.
        Then you can add attributes like variables and objects to this session object, and you can 
        retrieve the values of these attributes.

        In general it's considered a best practice to implement session tracking by using cookies.

        Persistent cookies are stored on the user's PC while per-session cookies are deleted when the session ends.

 Chapter 08 
        The JSP Expression Lenguage(EL) provides a compact syntax that lets you get dataa from JavaBeans, maps, arrays and list
        that have been stored as an attribute of a web application

        A JavaBean us a special type of object that provides a standar way to access its properties

        You can use other EL operators to perform calculations and make comparison.
        
        If necessary, you can disable EL or scrpting for one or mor pages in a web application.

Chapter 09 
        The JSP Standar Tag Library (JSTL) provides tags for common task that need to be performed in JSPs.

        Before you can use JSTL tags, you must make the jstl-impl.jar and jstl-api.jar files available to the application.

        Before you can use the JSTL tags in a JSP, you must code a taglib directive for the library that you want to use.

        You can use the forTokens tag to loop throught items in a delimited string 

        You can use the if tag to code the equivalent of a Java if statement

        You can use the choose tag to code the equivalent of a Java if/else statement

Chapter 10
        To create a custom tag that can be used in a JSP, you must create an XML file called the Tag Library Description (TLD). This TLD defines the tag library that contains the custom tags for an application

        To implement a custom tag that's defined in the TLD, you code a tag class which can also be referred to as a tag handler class. This is a class that implements the Tag interface, usually by extending the TagSupport class

        As you code the tag classes, you can use the methods and fields of the TagSupport, PageContext, bodyTagSupport and Bodycontent classes of the JAVA EE API


