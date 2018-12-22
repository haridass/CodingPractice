
1) Tell me a situation, where you missed a deadline  ( Please tell me which situation sounds better ? )
Situation 3
Missed deadline due to version missmatch 
I was working on a project that was adding a machine learning functionality to the exiting word matching functionality. The data scientist gave the code and my job was to put the code into production pipeline with all the java interfaces and coordination with all the component of the flow. Before the start of the sprint the data scientist gave a demonstration of his code using spark web UI. The code had two modules training and prediction. Training would generate a model and prediction would use that model.  I cross checked all possible situations the code could go wrong, for example the code was using string to numeric convertor, I checked if the numeric returned was same every time the same string was sent.  1.5 weeks into the sprint I was done with training code as expected but then hit a road block when I tried to save the model to HDFS. The code the data scientist used to give demonstration ran a single instance of training and prediction, it did not have to save the model to HDFS, where as with the production code, the users would run the training first and probably a month later they would run prediction, so the model has to be saved to HDFS. Also, the code written by data scientist used spark version 2.0 and the production server had version 1.5.0, so some components of the code given would not work on the production server. I communicated this issue to the client as early as possible and also communicated this to my boss and got 2-3 other data scientist involved. As we worked on hacking the code we encountered even more problems and had to push the deadline by 4 more days. 


2) What will you do if you are sure to miss a deadline?
The first thing I would do is to communicate to the clients that everything cannot be delivered by the deadline. I would ask the client to prioritize the most essential functionality of the product for the product to be viable. Give a brief explanation of why the deadline would be missed ( for example either the version of open source does not have the functionality expected or there is a bug with the version being used) . I would also communicate the issue to my boss and try to involve as many resources as possible. Request for a bridge call with as many resources as possible, because there might be some one who has already faced this situation and might have an alternative solution.  Analyze what went wrong and make sure that it would not happen again. 


3)  

Situation: Team mate had set up case sensitivity to off in the spark context initialization and could not figure that out.  
action:  This situation happens very often, and It becomes very productive to figure out a bug when some one with fresh mind looks at the code. When my team mates are stuck with any bug. I just walk through their code, speak out loud what I think about their code, and during the discussion it oftens turns out that they missed something.

I take up meeting notes and send it, soon after the meeting. So that no one misses points discussed during the meeting

I was coordinating and distributing the work to off shore team.  I tried to allocate sub-tasks to individuals that suit their interest and experience. 

I noticed that simple things like documenting the correct links to servers in confluence helps team member as they do not have to search through their emails 

Many a times my team mates have appreciated my efforts in trying things first. If there is some technology that is new to the team like CI process. Trying it out first and documenting the pitfalls helped the team.

  Active Contribution: Working with Data Science team, did not know much statistical 
 

 Tell me about a situation where you went against your boss? ( Insist on high standards)
Situation: Conflict with client delivery priorities. One risk of losing exiting client, other risk of not getting new client. Boss not on ground was not aware of my bandwidth. 
Action: Proposed a junior developer, initially was reluctant. But, I assured I would oversee and the task should not be that challenging for junior developer
Results: Both Project went well

Situation: Hbase for logging as opposed to database
Action: Manager suggested logging in postgres, I showed him how logging in Hbase was very useful in deriving metrics and querying real time
Result: Manager was impressed he appreciated the approach but he said he tried to convince the client to install Hbase and it could not be done in the given time frame. 


Tell me about a situation where your work was Criticized and went your way ( Insist on high standards)
Situation: There was a project to do Search metrics comparisons of Machine learning models. While there was no hard deadline for the project, it was critical to get it working fast as we did not have budget allocation for that project and could not spend a lot of time on that. I was criticized for taking 5 more days than other developer who completed the work in a day. 

Action: Arranged the meeting with manager and showed him the additional use case I thought through. The code I wrote allowed users to make minor changes and compare between different runs, while allowing users to mark particular results as baseline. Since the team was trying out different parameter tuning it was imperative to be able to mark particular runs as baseline with out manual intervention. 

Result: The client manager was happy that I thought through so many scenarios and he asked me to present the process to whole team, so that people can follow similar approaches in their respective project. 


Tell me a Situation where you had to work with a difficult client ? (Bias for Action, Earn Trust)
Situation: Cars.com deadline was due by more than a month
Task: Pacify the client and delivery the project
Action: Started showing results from Day1, prepared sample output. Mocked the Results and demonstrated code flow with unit test case. Actively involved client and gave demos of my progress. 
Result: Earned Trust and delivered project on time

Situation: Nielsen, an escalation was made saying my part of the code was not working and dropping request. 
Task: Had to disabuse. 
Action: Pulled up logs, scheduled meeting and clarified the notion. 

Tell me a situation where you were a good team player / Tell me about a situation where you went above and beyond (Ownership)
Situation: Off-shore team came onsite except for one person, who joined new. He is a QA resource.
Task: Need to bring that person up to speed with the project
Action: Scheduled call daily share resource links project plan
Result: That person was very appreciative of my effort and was very proactive in responding to my request. That person performed well and became the QA lead for the project. 

Situation: Current project, expectation was to move Machine learning code to production with no changes.  The code was built year ago and people were had to reach. Lead for the project. Code was in bits and pieces. No way the code would run. 
Task: Need to complete the project. 
Action: Used python SQL parses and compared the input columns with script columns, rewrote some logic in the code and got it confirmed. Raised it as risk for Data Science team to validate. Had multiple discussion with clients to get things confirmed. 
Result: Was able to complete project on time. 

Situation: Sev 1,  Person responsible was out of office
Task: Need to resolve Sev1 
Action: Looked into the logs, followed up with clients on input and figured out the it was a memory issue. 
Result: Client appreciated the effort. 

Situation: Colleague stuck in running queries in Production environment
Action:  Helped her identify duplicate records which ended up creating billions of records. 
Result: Colleague was able to complete the project on time. 

Situation: Tight SLA for job to run. Data Science team algorithm took more time. 
Action: During discussion figure out they were using whole words for the DBSca

If you were given a chance how would you do differently 
1) Using Jackson parser from the begining.  Clean code
2) Rebuild the spark part using latest ML libraries. 
3) Probably not so heavy weight for lot of customers. ( Was built with anticipation of heavy weight clients)
4) All logging in HBase. 
5) Streaming results as we compute as user does not need all the results. 
6) Input data validation 




Customer Obsession:
Situation:ML ops, defining the ML operation platform, no specific requirements. 
Action: Created a flow diagram for the client to visualize the flow and talk about the specifics
Results: Client was able to finalize the requirements and expedited the project kick off

Situation: Users lacked a common way to look at the metrics of jobs submitted, often there were question of how long would the job take. 
Action: Created an Monitoring user application, that logs all the history of the jobs and uses various OOZIE APIs. Created Rest API call, logging in Postgres data base
Result:   One stop shop for all the user requests. 

Situation: Cars.com

Invent and Simplify:
Situation: Junior team developer was spending more time in manually going through 
Action: Researched on SQL python packages for SQL parsing
Result: Improved efficiency 



Are Right a lot
Tell me about an error in judgment you made in the last year or two, what it was and the impact of it ?
Situation:  Thought of creating API for logging and log to Database. Expectation was to log step by step process and create and API for production support team to query for specific problem directly and also provide statictics on logging. It was not possible in give time frame. 
Action: Revetted to logging to file system and pushing to Hadoop 
Result:  Lost some time in development effort, but did not impact the project as the format of logging we decided on did not change a lot. 

Tell me a Situation where you made decision with no data ?
Situation: Project timeline, first time moving code to production. Lots of problems with access issues and other documentation. Creating Anaconda environment thought to be developers jobs. 
Action: Gathered information of time required for access to be raised and process, estimated  on time.
Result: Was able to complete project on time. The decision turn out to be correct , listened to my colleague suggestion of involving admin for the job

Situation: Colleague not performing
Action: Spent time with colleague in coding up most of the portion
Result: Was able to complete project on time, learning to get feedback specially on project with hard deadlines. 

Tell me about a time when you had to analyze facts quickly, define key issues, and respond immediately to a situation. What was the outcome?
Situation: Responding to Sev 1. 
Action: Raise memory, Identify root cause.

Situation: Data Science team used more that allocated memory
Action: Increase memory 