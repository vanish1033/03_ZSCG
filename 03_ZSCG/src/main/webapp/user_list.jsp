<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>monkey1024</title>
    <link href="css/bootstrap.css" rel="stylesheet">

</head>
<body>
<div class="container theme-showcase" role="main">
	<div id="msg">
		<div class="alert alert-info" role="alert">删除成功!</div>
	</div>
    <div class="page-header">
        <input type="text" name="id" placeholder="请输入id">
        <button id="query" type="button" class="btn btn-sm btn-primary">查询</button>
        <button id="add" type="button" class="btn btn-sm btn-success">添加</button>
    </div>
    <div class="row">
        <div class="">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th>编号</th>
                    <th>姓名</th>
                    <th>手机</th>
                    <th>生日</th>
                    <th>地址</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>1</td>
                    <td>jack</td>
                    <td>15188888888</td>
					<td>2010-01-01</td>
                    <td>北京</td>
                    <td>
                        <button type="button" class="btn btn-sm btn-info">删除</button>
                        <button type="button" class="btn btn-sm btn-warning">修改</button>
                    </td>
                </tr>
                <tr>
                    <td>2</td>
                    <td>paul</td>
                    <td>15188888888</td>
					<td>2018-01-01</td>
                    <td>上海</td>
                    <td>
                        <button type="button" class="btn btn-sm btn-info">删除</button>
                        <button type="button" class="btn btn-sm btn-warning">修改</button>
                    </td>
                </tr>
                <tr>
                    <td>3</td>
                    <td>andy</td>
                    <td>15188888888</td>
					<td>2016-01-01</td>
                    <td>广州</td>
                    <td>
                        <button type="button" class="btn btn-sm btn-info">删除</button>
                        <button type="button" class="btn btn-sm btn-warning">修改</button>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>
<script src="js/jquery-3.3.1.min.js"></script>
<script src="js/bootstrap.js"></script>
<script>
    $(function () {

    });
</script>
</body>
</html>
