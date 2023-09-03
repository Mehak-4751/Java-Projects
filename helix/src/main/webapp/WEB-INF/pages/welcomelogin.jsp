<html>
<head>
    <script type="text/javascript" src="/static/js/hello.js"> </script>
    <link rel="icon" type="image/x-icon" href="/static/images/Twitter_image.ico">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
    <style>
       @import url('https://fonts.googleapis.com/css?family=Montserrat:400,500&display=swap');

       body {
       	font-family: Montserrat,Arial, Helvetica, sans-serif;
       	background-color:#00acee;
       }
       * {box-sizing: border-box}

       /* Add padding to container elements */
       .container {
           padding: 20px;
             width:500px;
           position: absolute;
           left: 50%;
           top: 50%;
           transform: translate(-50%, -50%);
             border:1px solid #ccc;
             border-radius:10px;
             background:white;
         -webkit-box-shadow: 2px 1px 21px -9px rgba(0,0,0,0.38);
         -moz-box-shadow: 2px 1px 21px -9px rgba(0,0,0,0.38);
         box-shadow: 2px 1px 21px -9px rgba(0,0,0,0.38);
         }

       /* Full-width input fields */
       input[type=text], input[type=password] {
         width: 100%;
         padding: 15px;
         margin: 5px 0 22px 0;
         display: inline-block;
         border: none;
         background: #00acee
       	font-family: Montserrat,Arial, Helvetica, sans-serif;
       }
       select {
         width: 18%;
         padding: 15px;
         margin: 5px 0 22px 0;
         display: inline-block;
         border: none;
         background: #00acee
       	font-family: Montserrat,Arial, Helvetica, sans-serif;
       }

       input[type=text]:focus, input[type=password]:focus, input[type=phone]:focus, select:focus {
         background-color: #ddd;
         outline: none;
       }



       /* Set a style for all buttons */
       button {
         background-color: #00acee;
         color: white;
         padding: 14px 20px;
         margin: 8px 0;
         border: none;
         cursor: pointer;
         width: 100%;
         opacity: 0.9;
       	font-size:16px;
       	font-family: Montserrat,Arial, Helvetica, sans-serif;
       	border-radius:10px;
       }

       button:hover {
         opacity:1;
       }

       /* Change styles for signup button on extra small screens */
       @media screen and (max-width: 300px) {
         .signupbtn {
            width: 100%;
         }
       }
    </style>
</head>
<body>
    <form>
            <div class="container">
              <h1>Login your account</h1>
              <p>Welcome to Mission Helix</p>
              <label for="email"><b>Email</b></label>
              <input id="signup-email" type="text" placeholder="Enter Email" name="email">
              <label for="psw"><b>Password</b></label>
              <input id="signup-password" type="password" placeholder="Enter Password" name="psw">

              <p style="color:red; display:none" id="signup-error"></p>

              <div class="clearfix">
                <button id="signup-btn" type="button" >Login</button>
              </div>
            </div>
          </form>
    </div>

    <script>
        function validateSignUpForm(){
            var email=$("#signup-email").val();
            var password=$("#signup-password").val();

            var error="";
            if(!email){
                error+="Email is empty. ";
            }
            if(!password){
                error+="Password is empty. ";
            }
            if(!!password && password.length<=3){
                error+="Password length should be greater than 3.";
            }
            $("#signup-error").html(error);
            if(error.length>0){
                return false;
            }
            return true;
        }

        $("#signup-btn").click(function(){
            var isFormValid=validateSignUpForm();
            if(isFormValid){
                $("#signup-error").hide();

                var email=$("#signup-email").val();
                var password=$("#signup-password").val();
                var user={"email":email,"password":password};
                $.ajax({
                  type: "POST",
                  url: "/login/welcome",
                  data: JSON.stringify(user),
                  success: function(response){
                        if(response){
                            if(response.is_verified===true){
                                location.href="/user/welcome";
                            }else{
                                $("#signup-error").html(response.message);
                                $("#signup-error").show();
                            }
                        }
                   },
                  contentType: "application/json"
                });
            }else{
                $("#signup-error").show();
            }
        });
    </script>
</body>
</html>