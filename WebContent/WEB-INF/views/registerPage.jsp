<form action="register" method="post" style="border:1px solid #ccc">
  <div class="container">
    <h1>Sign Up</h1>
    <p>Please fill in this form to create an account.</p>
    <hr>

    <label for="userid"><b>User ID</b></label>
    <input type="text" placeholder="Enter User" name="userid" required>

    <label for="firstname"><b>First Name</b></label>
    <input type="text" placeholder="Enter First Name" name="firstname" required>

    <label for="lastname"><b>Last Name</b></label>
    <input type="text" placeholder="Last Name" name="lastname" required>

	<label for="address"><b>Address </b></label>
    <input type="text" placeholder="Address" name="address" required>
    
    <label for="contact"><b>Contact </b></label>
    <input type="text" placeholder="contact" name="contact" required>
    
    <label>
      <input type="checkbox" checked="checked" name="remember" style="margin-bottom:15px"> Remember me
    </label>

    <p>By creating an account you agree to our <a href="#" style="color:dodgerblue">Terms & Privacy</a>.</p>

    <div class="clearfix">
      <button type="button" class="cancelbtn">Cancel</button>
      <button type="submit" class="signupbtn">Sign Up</button>
    </div>
  </div>
</form>