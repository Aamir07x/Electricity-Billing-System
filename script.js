// Method for Registration page
function validateForm(){

        // for inputs
    const name = document.getElementById("name").value;
    const email = document.getElementById("email").value;
    const number = document.getElementById("contactNumber").value;
    const username = document.getElementById("userName").value;
    const password  = document.getElementById("password").value;
    const confirmPassword = document.getElementById("confirmPassword").value;
    const address = document.getElementById("address").value;
    const country = document.getElementById("country").value;
    const agree = document.getElementById("agree").checked;

        // for errors
    const nameError = document.getElementById("name-error");
    const emailError = document.getElementById("email-error");
    const numberError = document.getElementById("contactNumber-error");
    const usernameError = document.getElementById("userName-error");
    // const Password = document.getElementById("password-error");
    const confirmpasswordError = document.getElementById("confirmPassword-error");
    const addressError = document.getElementById("address-error");
    const countryError = document.getElementById("country-error");
    const agreeError = document.getElementById("agree-error");


    // Initially empty data
    nameError.textContent="";
    emailError.textContent="";
    numberError.textContent="";
    usernameError.textContent="";
    // passwordError.textContent="";
    confirmpasswordError.textContent="";
    addressError.textContent="";
    countryError.textContent="";
    agreeError.textContent="";



    // checking for validation of the data
    let isValid = true;

    if (name === "" || /\d/.test(name))
    {
        nameError.textContent = "Please Enter your nanme properly";
        isValid = false;
    }

    if (email === "" || !email.includes("@"))
    {
        emailError.textContent = "Please Enter valid email";
        isValid = false;
    }

    if (number === "" || isNaN(number))
    {
        numberError.textContent = "Please Enter valid Contact Number";
        isValid = false;
    }

    if (username === "")
    {
        usernameError.textContent = "Please Enter valid user Name";
        isValid = false;
    }

    // if ( password=== "" || password.length < 8 )
    //     {
    //         passwordError.textContent = "Please Enter atleast length of 8 digits password";
    //         isValid = false;
    //     }

    if (confirmPassword || password.length < 8  )
            {
                confirmpasswordError.textContent = "Please Enter atleast length of 8 digits password";
                isValid = false;
            }

    if ( address=== "")
        {
            addressError.textContent = "Please Enter your address";
            isValid = false;
        }
    
    if ( country=== "")
    {
        countryError.textContent = "Please select country name";
        isValid = false;
    }
        

    if (!agree)
        {
            agreeError.textContent = "Plase tick the box";
            isValid = false;
        }

    return isValid;

}

// Method for login page

function loginCheck(){

    // read the value 
    const email = document.getElementById("email").value;
    const password = document.getElementById("password").value;

    // for errors
    const emailError = document.getElementById("email-error");
    const passwordError = document.getElementById("password-error")

    // intially empty data
    email.textContent = "";
    password.textContent = "";

    // codition checking for errors
    let isValid = true;

    if (email === "" || !email.includes("@"))
    {
        emailError.textContent = "Please valid email-addres";
        isValid = false;
    }

    if (password === "" || password.length <8)
    {
        passwordError.textContent = "Enter password (atleast 8 digits or characters)";
        isValid = false;
    }

    return isValid;
}

// method for bill calculation
function checkBill(){
    const name = document.getElementById("name").value;
    const unitConsumed = document.getElementById("unitConsumed").value;
    const country = document.getElementById("country").value;


    const nameError = document.getElementById("name-error");
    const unitConsumedError = document.getElementById("unitConsumed-error");
    const countryError = document.getElementById("country-error");

    // Initially empty data
    nameError.textContent="";
    unitConsumedError.textContent="";
    countryError.textContent="";

    // condition checking
    let isValid = true;

    if (name === "" || /\d/.test(name))
        {
            nameError.textContent = "Please Enter your name or valid input";
            isValid = false;
        }  
        
    if (unitConsumed === "" || isNaN)
        {
            unitConsumedError.textContent = "Please enter valid input";
            isValid = false;
        } 
    
    if (country ==="")
        {
            unitConsumedError.textContent = "Please select your country";
            isValid = false;
        } 

        return isValid;
}

// method for payment errors
function payCheck(){
    // reads the value of input
    const consumerID = document.getElementById("consumerID").value;
    const name = document.getElementById("name").value;
    const email = document.getElementById("email").value;
    const contactNumber = document.getElementById("contactNumber").value;
    const unitConsumed = document.getElementById("unitConsumed").value;
    const country = document.getElementById("country").value;
    const amount = document.getElementById("amount").value;


    const consumerIDError = document.getElementById("consumerID-error");
    const nameError = document.getElementById("name-error");
    const emailError = document.getElementById("email-error");
    const contactNumberError = document.getElementById("contactNumber-error");
    const unitConsumedError = document.getElementById("unitConsumed-error");
    const countryError = document.getElementById("country-error");
    const amountError = document.getElementById("amount-error");

    // Initially empty data
    consumerIDError.textContent="";
    nameError.textContent="";
    emailError.textContent="";
    contactNumberError.textContent="";
    unitConsumedError.textContent="";
    countryError.textContent="";
    amountError.textContent="";

    // condition checking
    let isValid = true;

    if (consumerID === "")
        {
            consumerIDError.textContent = "Please Enter your consumerID";
            isValid = false;
        }

    if (name === "" || /\d/.test(name))
        {
            nameError.textContent = "Please Enter your name or valid input";
            isValid = false;
        }  

    if (email ==="" || email.includes("@"))
        {
            emailError.textContent = "Please Enter valid email";
            isValid = false;
        }

    if (contactNumber === "" || isNaN(number))
    {
        contactNumberError.textContent = "Please Enter valid Contact Number";
        isValid = false;
    }
        
    if (unitConsumed === "" || isNaN)
        {
            unitConsumedError.textContent = "Please enter valid input";
            isValid = false;
        } 
    
    if (country ==="")
        {
            countryError.textContent = "Please select your country";
            isValid = false;
        } 

    if (amount === "" || isNaN(number))
    {
        amountError.textContent = "Please Enter amount to pay";
        isValid = false;
    }

        return isValid;
}
