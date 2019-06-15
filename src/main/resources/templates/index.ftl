<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>AJAX增删改查</title>
    <script type="text/javascript" src="../js/jquery-1.11.0.js"></script>

</head>
<body>
<div >
    <form id="form1">
        姓 名：<input type="text" name="username" id="username" placeholder="请输入查询用户名">
        <input type="button" id="get_btn" value="查询">
    </form>
</div>
<br>
<hr>
<div >
    <form id="form2">
       用户ID： <input type="text" name="aid" id="aid" placeholder="请输入关键字">&nbsp;<br>
       姓  名：<input type="text" name="name" id="name" placeholder="请输入用户名">&nbsp;<br>
       密  码： <input type="text" name="psw" id="psw" placeholder="请输入用户密码">&nbsp;<br>
        <input type="button" id="post_btn" value="添加">&nbsp;
    </form>
</div>
<br>
<hr>
<div >
    <form id="form3">
        用户ID： <input type="text" name="pid" id="pid" placeholder="请输入关键字">&nbsp;<br>
        姓  名：<input type="text" name="pname" id="pname" placeholder="请输入用户名">&nbsp;<br>
        密  码： <input type="text" name="ppsw" id="ppsw" placeholder="请输入用户密码">&nbsp;<br>
        <input type="button" id="put_btn" value="修改">&nbsp;
    </form>
</div>

<br>
<hr>
<div >
    <form id="form4">
        用户ID： <input type="text" name="did" id="did" placeholder="要删除的id">
        <input type="button" id="del_btn" value="删除">
    </form>
</div>

<script>

    $(function () {


        $("#del_btn").click(function () {
            var id = $("#did").val();
            if(id==""){
                alert("id错误")
                return;
            }
            $.ajax({
                type:"delete",
                dataType:"json",
                url:"/home/del/"+id,
                statusCode: {
                    200:function () {
                        alert("修改成功")
                    },
                    204:function () {
                        alert("修改失败")
                    }
                }
            });
        }),






        $("#put_btn").click(function () {
            var id = $("#pid").val();
            var username = $("#pname").val();
            var password = $("#ppsw").val();
            if(id==""){
                alert("id错误")
                return;
            }
            $.ajax({
                type:"PUT",
                dataType:"json",
                url:"/home/update/"+id+"/"+username+"/"+password,
                statusCode: {
                    200:function () {
                        alert("修改成功")
                    },
                    204:function () {
                        alert("修改失败")
                    }
                }
            });
        }),

        $("#post_btn").click(function () {

           /* //如果添加的是实体user
            var user={
                "id":"用户id"
                "username":"用户名",
                "password":"密码"
            };
            var json=JSON.stringify(user);
            ajax里 data:json
            */
            var id = $("#aid").val();
            var username = $("#name").val();
            var password = $("#psw").val();
            if (id == "")
            {
                alert("输入不完整")
                return;
            }
            $.ajax({
                type: "POST",
                url: "/home/add/"+id+"/"+username+"/"+password,
                dataType: "json",
                statusCode: {
                    200: function () {
                        alert("添加成功")
                    }//,
                    // 204:function () {
                    //     alert("添加失败")
                    // }
                }

            });
        }),


                $("#get_btn").click(function () {
                    var username = $("#username").val();  //获取输入的信息
                    if (username == "") {              //如果没有数据，就return掉
                        alert("内容不为空");
                        return;
                    }
                    $.ajax({
                        type: "get",
                        url: "/home/query/" + $("#username").val(),
                        // data: {"username": username},
                        dataType: "json",
                        statusCode: {
                            200: function (data) {
                                var jsonData = JSON.stringify(data);// 转成JSON格式
                                // var result = $.parseJSON(jsonData);// 转成JSON对象
                                alert(jsonData)
                            },
                            204: function () {
                                alert("查询失败")
                            }
                        }
                    });
                })
    })
</script>


</body>
</html>