<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Insurance Tracker - Login</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gray-100">
<nav class="bg-white shadow-md">
    <div class="max-w-7xl mx-auto px-4 sm:px-6 lg:px-8">
        <div class="flex justify-between h-16">
            <div class="flex">
                <div class="flex-shrink-0 flex items-center">
                    <a href="/" class="text-2xl font-bold text-blue-600">Insurance Tracker</a>
                </div>
                <div class="hidden sm:-my-px sm:ml-6 sm:flex sm:items-center sm:space-x-8">
                    <a href="/" class="border-b-2 border-transparent text-gray-500 hover:border-blue-600 hover:text-blue-600 px-3 py-2 text-sm font-medium">Home</a>
                    <a href="/#" class="border-b-2 border-transparent text-gray-500 hover:border-blue-600 hover:text-blue-600 px-3 py-2 text-sm font-medium">Services</a>
                    <a href="/#" class="border-b-2 border-transparent text-gray-500 hover:border-blue-600 hover:text-blue-600 px-3 py-2 text-sm font-medium">About Us</a>
                    <a href="/#" class="border-b-2 border-transparent text-gray-500 hover:border-blue-600 hover:text-blue-600 px-3 py-2 text-sm font-medium">Contact</a>
                </div>
            </div>
            <div class="hidden sm:flex sm:items-center">
                <a href="/Auth/login" class="text-sm font-medium text-gray-500 hover:text-blue-600">Login</a>
                <a href="/Auth/register" class="ml-4 text-sm font-medium text-white bg-blue-600 hover:bg-blue-700 px-3 py-2 rounded-md">Register</a>
            </div>
        </div>
    </div>
</nav>

<section class="flex items-center justify-center py-20">
    <div class="bg-white p-8 rounded-lg shadow-lg max-w-md w-full">
        <h2 class="text-3xl font-semibold text-center text-blue-600 mb-6">Login to Your Account</h2>
        <form action="/Auth/login" method="post" class="space-y-6">
            <div>
                <label for="email" class="block text-sm font-medium text-gray-700">Email</label>
                <div class="mt-1">
                    <input id="email" name="email" type="email" required
                           class="w-full px-3 py-2 border border-gray-300 rounded-md shadow-sm focus:outline-none focus:ring-blue-500 focus:border-blue-500" />
                </div>
            </div>
            <div>
                <label for="password" class="block text-sm font-medium text-gray-700">Password</label>
                <div class="mt-1">
                    <input id="password" name="password" type="password" required
                           class="w-full px-3 py-2 border border-gray-300 rounded-md shadow-sm focus:outline-none focus:ring-blue-500 focus:border-blue-500" />
                </div>
            </div>
            <c:if test="${not empty error}">
                <p style="color:red">${error}</p>
            </c:if>
            <div class="flex items-center justify-between">
                <div class="flex items-center">
                    <input id="remember_me" name="remember_me" type="checkbox"
                           class="h-4 w-4 text-blue-600 focus:ring-blue-500 border-gray-300 rounded">
                    <label for="remember_me" class="ml-2 block text-sm text-gray-900">Remember me</label>
                </div>
                <div class="text-sm">
                    <a href="/forgot-password" class="font-medium text-blue-600 hover:text-blue-500">Forgot your password?</a>
                </div>
            </div>
            <div>
                <button type="submit"
                        class="w-full flex justify-center py-2 px-4 border border-transparent rounded-md shadow-sm text-sm font-medium text-white bg-blue-600 hover:bg-blue-700 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-blue-500">
                    Sign In
                </button>
            </div>
        </form>
        <p class="text-center text-sm text-gray-600 mt-4">
            Don't have an account?
            <a href="/register" class="font-medium text-blue-600 hover:text-blue-500">Register here</a>.
        </p>
    </div>
</section>

</body>
</html>
