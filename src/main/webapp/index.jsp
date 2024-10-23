<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Insurance Tracker</title>
    <!-- Tailwind CSS CDN -->
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gray-100">

<!-- Navbar -->
<nav class="bg-white shadow-md py-4">
    <div class="container mx-auto flex justify-between items-center">
        <!-- Logo -->
        <a href="/" class="text-2xl font-semibold text-blue-600">Insurance Tracker</a>
        <!-- Navigation Links -->
        <div class="space-x-6">
            <a href="/" class="text-gray-700 hover:text-blue-600">Home</a>
            <a href="/#" class="text-gray-700 hover:text-blue-600">About</a>
            <a href="/#" class="text-gray-700 hover:text-blue-600">Contact</a>
        </div>
        <!-- Login & Register Buttons -->
        <div class="space-x-4">
            <a href="/Auth/login" class="bg-blue-600 text-white px-4 py-2 rounded hover:bg-blue-700">Login</a>
            <a href="/Auth/register" class="bg-gray-200 text-gray-700 px-4 py-2 rounded hover:bg-gray-300">Register</a>
        </div>
    </div>
</nav>

<!-- Hero Section -->
<section class="bg-blue-600 text-white py-20">
    <div class="container mx-auto text-center">
        <h1 class="text-5xl font-bold">Welcome to Insurance Tracker</h1>
        <p class="mt-4 text-lg">Your one-stop solution for managing all your insurance needs.</p>
        <a href="/get-quote" class="mt-8 inline-block bg-white text-blue-600 px-6 py-3 rounded hover:bg-gray-200">
            Get a Quote
        </a>
    </div>
</section>

<!-- Features Section -->
<section class="py-16">
    <div class="container mx-auto text-center">
        <h2 class="text-3xl font-semibold mb-8">Why Choose Us?</h2>
        <div class="grid grid-cols-1 md:grid-cols-3 gap-8">
            <div class="bg-white p-6 rounded-lg shadow-lg">
                <h3 class="text-2xl font-bold text-blue-600 mb-4">Fast Claims</h3>
                <p>Get your insurance claims processed quickly and efficiently.</p>
            </div>
            <div class="bg-white p-6 rounded-lg shadow-lg">
                <h3 class="text-2xl font-bold text-blue-600 mb-4">Comprehensive Coverage</h3>
                <p>We provide a wide range of coverage for health, car, and home insurance.</p>
            </div>
            <div class="bg-white p-6 rounded-lg shadow-lg">
                <h3 class="text-2xl font-bold text-blue-600 mb-4">24/7 Support</h3>
                <p>Our support team is available round the clock to assist you.</p>
            </div>
        </div>
    </div>
</section>

<!-- Footer -->
<footer class="bg-gray-800 text-white py-8">
    <div class="container mx-auto text-center">
        <p class="text-sm">&copy; 2024 Insurance Tracker. All rights reserved.</p>
        <div class="space-x-4 mt-4">
            <a href="/privacy-policy" class="text-gray-400 hover:text-white">Privacy Policy</a>
            <a href="/terms" class="text-gray-400 hover:text-white">Terms of Service</a>
        </div>
    </div>
</footer>

</body>
</html>
