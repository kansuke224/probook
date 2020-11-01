var err_flg = 0;

function validate (self) {
  //const fieldName = self.previousElementSibling.innerHTML;
  
  try{
    if(!self.value){
      throw new Error("未入力です");
    }
    
    if(self.className === "invalid"){
      if(!/^[a-zA-Z0-9]+$/.test(self.value)){
        throw new Error("半角英数字で正しく入力してください");
      }
    }
    
    self.parentNode.nextElementSibling.innerHTML = "";
    self.parentNode.nextElementSibling.style.backgroundColor = "";
    self.parentNode.nextElementSibling.style.backgroundColor = "";
    
    
  }catch (err){
    err_flg = 1;
    //console.log(err.message);
    
    self.parentNode.nextElementSibling.innerHTML = err.message;
    //<p>タグを取得

    self.parentNode.nextElementSibling.style.backgroundColor = "pink";
    
    
  }
}

// onsubmit
function validateAll(){
    err_flg = 0;

    const inputList = document.getElementsByTagName("input");
    // console.log(inputList);


    for (let i = 9; i < inputList.length -1; i++){
      console.log(inputList[i]);
      validate(inputList[i]);
    }

    if (err_flg == 1) {
      console.log("error");
      return false;
    } else {
      return true;
    }

}