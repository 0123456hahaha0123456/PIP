<%--
  Created by IntelliJ IDEA.
  User: DucTran
  Date: 11/25/2018
  Time: 3:04 AM
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"
        language="java" import="java.util.List, java.util.ArrayList, itmo.AreaCheckServlet"
%>

<head>
  <meta charset="UTF-8">
  <title>Title</title>
  <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.0/jquery.min.js"></script>
  <script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
  <script type="text/javascript" src = "js/scripts.js"></script>
  <style type="text/css">
    #body{
      background-repeat: no-repeat;
      background-size: cover;
    }
    #name{
      width : 70%;
      background : #EDE7FA;
      color : #010101;
      height : 50px;
      float : left;
      font-size : 50px;
    }
    #name1{
      width : 70%;
      background : #EDE7FA;
      color : #010101;
      height : 50px;
      float : left;
      font-size : 50px;
    }
    #variant{
      width : 30%;
      background : #B397F4;
      color : #010101;
      height : 50px;
      float : right;
      font-size : 50px;
    }
    #number{
      width : 30%;
      background : #B397F4;
      color : #010101;
      height : 50px;
      float : right;
      font-size : 50px;
    }

    .container{
      width : 1000px;
      height: 800px;
      margin : 0 auto;
      color : #FEFEFE;
      position : relative;
      border: 1px solid #333;
      padding : 10px;
      overflow : auto;
      text-align : center;
    }

    table.center{
      margin : 0px auto;
      margin-top : 10px;
    }
    #form1{
      color : #010101;
      font-size: 0.5cm;
    }
    #work{
      margin-top: 2%;
      width : 40%;
      float : right;
    }
    #image{
      margin-top : 2%;
      width : 60%;
      float : left;
    }

  </style>
</head>

<body onload="drawCanas('canvas',1)">
<div id = body class="container">
  <div class = "header-style">
    <div id = name><b>TRAN TRUNG DUC P3202</b></div>
    <div id = variant> Variant </div>
    <div id = name1><b>LE TUAN DUNG  P3200</b></div>
    <div id = number> 20034 </div>
    <br>
  </div>
  <div id="image">
    <canvas id="canvas" onclick="clicCanvas('canvas',document.getElementById('3hsang').value)" style="background-color:#ffffff; border-radius: 20px;" width="300" height="300"></canvas>
  </div>


  <div id = "work">
    <form id = "form1" action="control" method="GET" >

         Input X :<br>
       <input value=-2   name="valueX" class="subject-list" type="checkbox">-2
       <input value=-1.5 name="valueX" class="subject-list" type="checkbox">-1.5
       <input value=-1   name="valueX" class="subject-list" type="checkbox">-1
       <input value=-0.5 name="valueX" class="subject-list" type="checkbox">-0.5
       <input value=0    name="valueX" class="subject-list" type="checkbox">0
       <input value=0.5  name="valueX" class="subject-list" type="checkbox">0.5
       <input value=1    name="valueX" class="subject-list" type="checkbox">1
       <input value=1.5  name="valueX" class="subject-list" type="checkbox">1.5
       <input value=2    name="valueX" class="subject-list" type="checkbox">2
         <script type="text/javascript">
               $('.subject-list').on('change', function() {
              $('.subject-list').not(this).prop('checked', false);
          });
       </script>

      <label for="valueY">Input Y : </label><br>
      <input required type = "text"  id = "valueY" name ="valueY" pattern="-?(\d{1,2})(\.\d{0,3})?"  placeholder="{-5..3}" > <br>

      Input  R: <br>
      <select name = "valueR" id = "3hsang" onchange="drawCanas('canvas',this.value)">
        <option required  value = 1>1</option>
        <option value = 2>2</option>
        <option value = 3>3</option>
        <option value = 4>4</option>
        <option value = 5>5</option>
      </select>
      <br>
        <!--<input type = "button" id = "submit1" value ="submit">-->
       <button id = "submit1"> Submit </button>

    </form>

      <input hidden type ="text" name="valueX" id = "valueX" value=""> <br>

  </div>

  <script type="text/javascript">
      var form = document.querySelector('#form1');
      var text = document.querySelector("#valueY");
      var check = document.getElementsByName("valueX")[0];

      form.addEventListener("submit",function(event){
          if (isNaN(text.value) || (text.value <-5) || (text.value >3)){
              text.style.boxShadow= "0 0 10px red";
              event.preventDefault();
          }
      });

      $(document).ready(function () {
          $('#submit1').click(function() {
              _checked = $("input[type=checkbox]:checked").length;

              if(!_checked) {
                  check.style.boxShadow = "0 0 10px red";
                  return false;
              }
          });
      });

      var _form = $('#canvas');
      _form.click(function () {
          $.ajax({
              type: "GET",
              url: "control",
              data : {
                  valueX : $("#valueX").val(),
                  valueY : $("#valueY").val(),
                  valueR : $("#3hsang").val()
              },
              success: function (data) {
                 // $('#test').attr("value",data);
                 // $('thanhcong').html("Enjoy your result!")
              }
          });

          return false;
      });

  </script>
</div>
</body>
</html>
