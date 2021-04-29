 
  const sign_in_btn = document.querySelector("#sign-in-btn");
  const sign_up_btn = document.querySelector("#sign-up-btn");
  const container = document.querySelector(".container");
  
  sign_up_btn.addEventListener("click", () => {
    container.classList.add("sign-up-mode");
  });
  
  sign_in_btn.addEventListener("click", () => {
    container.classList.remove("sign-up-mode");
  });
  
    function postApi(val){
    var model = {
  
    "email" : this.$("#email").val(),
    "password" : this.$("#password").val(),
    "password2" : this.$("#Repeat-Password").val(),
  
  
    };
    console.log("post data:"+model);
      $.ajax(
      {
        type:"POST",
        url : "admin/addUser",
        
        ContentType:"application/json ;charset=UTF-8",
        
        crossOrigin:true,
        dataType:"json",
        headers: {
          'Accept': 'application/json',
          'Content-Type': 'application/json'
          },
        data:this.JSON.stringify(model),
        
        success:function(data)
        {
          console.log("successfuly"+data);
  
        },error:function(jqXHR,testStatus,errorThrown)
        {
        
        }
      }
      );
    }
    
  
  
  
  
  
  
  
  
  
  
  $(document).ready(function(){
    $.ajax(
        {
          type:"get",
          url : "admin/getAllerror",
          
          ContentType:"application/json ;charset=UTF-8",
          
          crossOrigin:true,
          dataType:"json",
          headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
            },
          
          
          success:function(result)
          {
            console.log(result)
  
  
            if(result[0]==="true"){
              window.location.replace("login.html");
            }
  else	if(result.length>0){
  
      container.classList.add("sign-up-mode");
      document.getElementById("error").innerHTML = result[0];
    }else{
  
    }
         
  
          },error:function(jqXHR,testStatus,errorThrown)
          {
    
          }
        });
    });
  
  

  
  
  
  
  
  
  
  
  
  
  
  
  
  
    $(document).ready(function(){
    $.ajax(
        {
          type:"get",
          url : "admin/getAll",
          
          ContentType:"application/json ;charset=UTF-8",
          
          crossOrigin:true,
          dataType:"json",
          headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
            },
          
          
          success:function(result)
          {
            console.log(result)
            var table = $(".table")
            for(i=0;i<result.length;i++)
              {
                table.append('<tr><td>'+ result[i]["id"] + '</td>' +
                    '<td>'+result[i]["fname"] + '</td>'+
                    '<td>'+ result[i]["lname"] + '</td>'+
                    '<td>'+ result[i]["phone"] + '</td>'+
                    '<td>'+ result[i]["email"] + '</td>'+
                    '<td>'+ result[i]["password"]+ '</td>'+
                    '<td><button class="btn btn-danger" id="remove" onclick="removeUser('+result[i]["id"]+')">حذف</button></td></tr>'
                    
                
                );
                $('message').html(table);
              }
            console.log("successfuly"+data);
            alert("done");
          },error:function(jqXHR,testStatus,errorThrown)
          {
            alert("error");
          }
        });
    });

  function removeUser(id){
           
           $.ajax({
                  url: "admin/deleteUser/id?id="+id,
                  method:'DELETE',
                  dataType:'json',
                  success:function(data){
                      alert("the user  number "+id+" is  deleted");
                      
                  
              },error: function(jqXHR,testStatus,errorThrown){
                alert("faild !!!");
              }
           });
  }
  
  





















