<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="org.example.model.TaskModel" %>
<%@ page import="java.util.List" %>
<%
    List<TaskModel> tasks = (List<TaskModel>) request.getAttribute("tasks");
    String filter = (String) request.getAttribute("filter");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>My To-Do List</title>
    <style>
        body {
          font-family: Arial, sans-serif;
          max-width: 600px;
          margin: 30px auto;
          padding: 0 15px;
          background: #f5f7fe;
        }
        h1 {
          text-align: center;
          margin-bottom: 20px;
        }
        .filter {
          text-align: center;
          margin-bottom: 20px;
        }
        .filter label {
          margin: 0 15px;
          font-weight: bold;
          cursor: pointer;
        }
        form {
          background: #c2d0f7;
          padding: 15px 20px;
          border-radius: 5px;
          box-shadow: 0 0 5px rgba(0,0,0,0.1);
          margin-bottom: 30px;
          display: flex;
          gap: 10px;
          flex-wrap: wrap;
          align-items: center;
        }
        form input[type="text"] {
          flex-grow: 2;
          padding: 8px;
          font-size: 1rem;
          border: 1px solid #ccc;
          border-radius: 3px;
        }
        form button {
          padding: 8px 15px;
          background-color: #5d83e9;
          border: none;
          color: white;
          font-weight: bold;
          border-radius: 3px;
          cursor: pointer;
          transition: background-color 0.3s ease;
        }
        form button:hover {
          background-color: #3262e3;
        }
        ul.task-list {
          list-style: none;
          padding: 0;
          min-height: 50px; /* to keep space visible when empty */
        }
        ul.task-list li {
          background: white;
          padding: 12px 15px;
          margin-bottom: 10px;
          border-radius: 5px;
          display: flex;
          align-items: center;
          box-shadow: 0 0 5px rgba(0,0,0,0.05);
        }
        ul.task-list li.done {
          text-decoration: line-through;
          color: #6c757d;
          background-color: #e9ecef;
        }
        ul.task-list li .task-checkbox {
          margin-right: 15px;
          transform: scale(1.2);
          cursor: pointer;
        }
        ul.task-list li .task-info {
          flex-grow: 1;
        }
        ul.task-list li .task-deadline {
          font-size: 0.9rem;
          color: #888;
          margin-left: 10px;
          white-space: nowrap;
        }
      </style>
</head>
<body>
<h1>My To-Do List</h1>

<div class="filter">
    <form method="get" action="home">
        <label><input type="radio" name="filter" value="all" <%= "all".equals(filter) ? "checked" : "" %> onchange="this.form.submit()"> All</label>
        <label><input type="radio" name="filter" value="done" <%= "done".equals(filter) ? "checked" : "" %> onchange="this.form.submit()"> Done</label>
        <label><input type="radio" name="filter" value="undone" <%= "undone".equals(filter) ? "checked" : "" %> onchange="this.form.submit()"> Undone</label>
    </form>
</div>

<form method="post" action="home">
    <input type="text" name="description" placeholder="Enter your task..." required />
    <input type="text" name="deadline" placeholder="Enter deadline (e.g. 2025-06-10)" required />
    <button type="submit">Add Task</button>
</form>

<ul class="task-list">
    <%
        if (tasks != null) {
            for (TaskModel task : tasks) {
    %>
    <li class="<%= task.getIsDone() ? "done" : "" %>">
        <form action="/task/updateStatus" method="post" style="margin:0; display:inline;">
            <input type="hidden" name="id" value="<%= task.getId() %>"/>
            <input class="task-checkbox" type="checkbox" name="isDone" value="true"
                onchange="this.form.submit();" <%= task.getIsDone() ? "checked" : "" %>/>
        </form>
        <div class="task-info"><%= task.getDescription() %></div>
        <div class="task-deadline"><%= task.getDeadline() %></div>
    </li>
    <%
            }
        }
    %>
</ul>

</body>
</html>
