<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>测试</title>
</head>
<body>
test5
<form action="/test5" method="get">
    姓名：<input type="text" name="name"><br>
    年龄：<input type="text" name="age"><br>
    学校地址：<input type="text" name="school.address"><br>
    学校名字：<input type="text" name="school.schoolname"><br>
    学校时间：<input type="date" name="localDate"><br>
    <input type="submit">

</form>
test4
<form action="/test4" method="post">
    姓名：<input type="text" name="name"><br>
    年龄：<input type="text" name="age"><br>

    <input type="submit">

</form>


test9
<form action="/test9" method="get">
    姓名：<input type="text" name="name">${nameError}<br>
    年龄：<input type="text" name="age">${ageError}<br>

    <input type="submit">


    </form>


test10——上传照片
<form action="/test10" enctype="multipart/form-data" method="post">
    图片：<input type="file" name="photo"><br>
    <input type="submit">
</form>

</body>
</html>
