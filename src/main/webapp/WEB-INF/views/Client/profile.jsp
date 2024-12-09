<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Profile</title>
    <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet">
    <style>
        .card:hover {
            transform: translateY(-5px);
            box-shadow: 0px 10px 15px rgba(0, 0, 0, 0.1);
            transition: all 0.3s ease;
        }
        .input-field:focus {
            outline: none;
            border-color: #3b82f6;
            box-shadow: 0 0 0 2px rgba(59, 130, 246, 0.5);
        }
        .save-button:hover {
            background-color: #2563eb;
        }
    </style>
</head>
<body>
<c:if test="${not empty sessionScope.alertMessage}">
    <div class="container mx-auto mt-4">
        <div class="bg-blue-100 border border-blue-400 text-blue-700 px-4 py-3 rounded relative" role="alert">
            <span class="block sm:inline">${sessionScope.alertMessage}</span>
            <button onclick="this.parentElement.style.display='none';" class="absolute top-0 bottom-0 right-0 px-4 py-3">
                <svg class="fill-current h-6 w-6 text-blue-500" role="button" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 20 20">
                    <path d="M14.348 5.652a1 1 0 010 1.415L11.414 10l2.934 2.933a1 1 0 01-1.415 1.415L10 11.414l-2.933 2.934a1 1 0 01-1.415-1.415L8.586 10 5.652 7.067a1 1 0 011.415-1.415L10 8.586l2.933-2.934a1 1 0 011.415 0z"/>
                </svg>
            </button>
        </div>
    </div>
</c:if>
<nav class="bg-blue-600 p-4 text-white shadow-md">
    <div class="container mx-auto flex justify-between items-center">
        <div>
            <a href="/Auth/client" class="text-xl font-bold">InsuranceTracker</a>
        </div>
        <div>
            <a href="/Auth/profile" class="px-4 hover:underline">Profile</a>
            <a href="/insurances" class="px-4 hover:underline">My Insurances</a>
            <a href="/Auth/logout" class="px-4 hover:underline">Logout</a>
        </div>
    </div>
</nav>
<div class="container mx-auto mt-10">
    <div class="bg-white p-6 rounded-lg shadow-md card max-w-xl mx-auto">
        <h2 class="text-2xl font-semibold text-gray-800 mb-5">User Profile</h2>
        <form action="/Auth/update" method="post" class="space-y-4">
            <div>
                <input
                        type="hidden"
                        id="id"
                        name="id"
                        class="w-full p-2 mt-2 border rounded-md input-field"
                        value="${user.id}"
                        >
                <label for="name" class="block text-gray-700 font-medium">Name</label>
                <input
                        type="text"
                        id="name"
                        name="name"
                        class="w-full p-2 mt-2 border rounded-md input-field"
                        value="${user.name}"
                        placeholder="Enter your name"
                        required>
            </div>
            <div>
                <label for="email" class="block text-gray-700 font-medium">Email</label>
                <input
                        type="email"
                        id="email"
                        name="email"
                        class="w-full p-2 mt-2 border rounded-md input-field"
                        value="${user.email}"
                        placeholder="Enter your email"
                        required>
            </div>
            <div>
                <label for="phone" class="block text-gray-700 font-medium">Phone Number:</label>
                <input
                        type="text"
                        id="phone"
                        name="phone"
                        class="w-full p-2 mt-2 border rounded-md input-field"
                        value="${user.phone}"
                        placeholder="Enter Phone Number"
                        required>
            </div>
            <div>
                <label for="Address" class="block text-gray-700 font-medium">Address:</label>
                <input
                        type="text"
                        id="Address"
                        name="address"
                        class="w-full p-2 mt-2 border rounded-md input-field"
                        value="${user.address}"
                        placeholder="Enter GPS coordinates"
                        required>
            </div>
            <div>
                <label for="password" class="block text-gray-700 font-medium">Password</label>
                <input
                        type="password"
                        id="password"
                        name="password"
                        class="w-full p-2 mt-2 border rounded-md input-field"
                        placeholder="Enter new password">
            </div>
            <div class="flex justify-end">
                <button
                        type="submit"
                        class="bg-blue-600 text-white py-2 px-6 rounded-md save-button transition-all duration-300 hover:bg-blue-700">
                    Save Changes
                </button>
            </div>
        </form>
    </div>
</div>
</body>
</html>
