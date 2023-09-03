$(".follow-member").click(function(event){
    var memberid=this.getAttribute("member-id");
    var button=this;
    var isFollowed=$(button).hasClass("followed-button");
    if(isFollowed){
        $.ajax({
          type: "POST",
          url: "/user/un-follow-member",
          data: memberid,
          success: function(response){
                if(response){
                    //button.style.backgroundColor="#018786";
                    $(button).removeClass("followed-button");
                    button.querySelector("span").innerHTML="Follow";
                }
           },
          contentType: "application/json"
        });
    }else{
        $.ajax({
          type: "POST",
          url: "/user/follow-member",
          data: memberid,
          success: function(response){
                if(response){
                    //button.style.backgroundColor="#018786";
                    $(button).addClass("followed-button");
                    button.querySelector("span").innerHTML="Followed";
                }
           },
          contentType: "application/json"
        });
    }
});