<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Register</title>
  <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gray-100">
<!-- Navbar -->
<nav class="bg-white shadow-md">
  <div class="container mx-auto px-4 py-2 flex justify-between items-center">
    <div class="text-xl font-bold">Insurance Tracker</div>
    <div>
      <a href="/Auth/login" class="text-blue-600 hover:text-blue-800 mx-2">Login</a>
      <a href="/Auth/register" class="text-blue-600 hover:text-blue-800 mx-2">Register</a>
    </div>
  </div>
</nav>

<!-- Registration Form -->
<div class="flex justify-center items-center min-h-screen">
  <div class="bg-white shadow-md rounded-lg p-8 w-full max-w-md">
    <h2 class="text-2xl font-bold text-center mb-6">Create an Account</h2>

    <form action="/Auth/register" method="post">
      <!-- Name -->
      <div class="mb-4">
        <label for="name" class="block text-gray-700 font-medium">Full Name</label>
        <input type="text" id="name" name="name" class="w-full px-4 py-2 border rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-500" placeholder="John Doe" required>
      </div>
      <div class="mb-4">
        <label for="phone" class="block text-gray-700 font-medium">Phone Number</label>
        <input type="text" id="phone" name="phone" class="w-full px-4 py-2 border rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-500" placeholder="+212765434567" required>
      </div>
      <div class="mb-4">
        <label for="address" class="block text-gray-700 font-medium">Address</label>
        <input type="text" id="address" name="address" class="w-full px-4 py-2 border rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-500" placeholder="+212765434567" required>
      </div>
      <!-- Email -->
      <div class="mb-4">
        <label for="email" class="block text-gray-700 font-medium">Email</label>
        <input type="email" id="email" name="email" class="w-full px-4 py-2 border rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-500" placeholder="you@example.com" required>
      </div>

      <!-- Password -->
      <div class="mb-6">
        <label for="password" class="block text-gray-700 font-medium">Password</label>
        <input type="password" id="password" name="password" class="w-full px-4 py-2 border rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-500" placeholder="••••••••" required>
      </div>

      <!-- Register Button -->
      <div class="mb-4">
        <button type="submit" class="w-full bg-blue-600 text-white py-2 px-4 rounded-lg hover:bg-blue-700 focus:outline-none focus:ring-2 focus:ring-blue-500">
          Register
        </button>
      </div>

      <!-- Already have an account -->
      <p class="text-center text-gray-600">Already have an account?
        <a href="/Auth/login" class="text-blue-600 hover:text-blue-800">Login</a>
      </p>
    </form>
  </div>
</div>
</body>
</html>
