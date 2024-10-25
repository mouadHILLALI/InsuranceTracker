<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Manage Car Insurance</title>
  <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet">
  <style>
    .card:hover {
      transform: translateY(-5px);
      box-shadow: 0px 10px 15px rgba(0, 0, 0, 0.1);
      transition: all 0.3s ease;
    }
  </style>
</head>
<body class="bg-gray-100">

<!-- Navigation Bar -->
<nav class="bg-blue-600 p-4 text-white shadow-md">
  <div class="container mx-auto flex justify-between items-center">
    <div>
      <a href="/Auth/client" class="text-xl font-bold">InsuranceTracker</a>
    </div>
    <div>
      <a href="/profile" class="px-4 hover:underline">Profile</a>
      <a href="/insurances" class="px-4 hover:underline">My Insurances</a>
      <a href="/Auth/logout" class="px-4 hover:underline">Logout</a>
    </div>
  </div>
</nav>

<!-- Car Insurance Management Section -->
<div class="container mx-auto mt-8">
  <div class="bg-white p-6 rounded-lg shadow-lg">
    <h2 class="text-2xl font-bold mb-6 text-gray-700">Manage Your Car Insurance</h2>

    <!-- Form for Car Insurance Management -->
    <form action="/insurance/createCar" method="post" class="grid grid-cols-1 md:grid-cols-2 gap-4">
      <!-- Policy Number -->
      <div>
        <label for="policyHolderName" class="block text-sm font-medium text-gray-700">Policy Holder Name :</label>
        <input type="text" id="policyHolderName" name="" required
               value="${user.name}"
               disabled
               class="mt-1 block w-full px-3 py-2 border border-gray-300 rounded-md shadow-sm focus:ring-blue-500 focus:border-blue-500 sm:text-sm">
        <input type="hidden" name="PolicyHolderName" value="${user.name}">
      </div>

      <!-- Car Model -->
      <div>
        <label for="startDate" class="block text-sm font-medium text-gray-700">Start Date :</label>
        <input type="date" id="startDate" name="startDate" required
               class="mt-1 block w-full px-3 py-2 border border-gray-300 rounded-md shadow-sm focus:ring-blue-500 focus:border-blue-500 sm:text-sm">
      </div>
      <div>
        <label for="endDate" class="block text-sm font-medium text-gray-700">End Date :</label>
        <input type="date" id="endDate" name="endDate" required
               class="mt-1 block w-full px-3 py-2 border border-gray-300 rounded-md shadow-sm focus:ring-blue-500 focus:border-blue-500 sm:text-sm">
      </div>

      <div>
        <label for="DriverAge" class="block text-sm font-medium text-gray-700">Driver Age :</label>
        <input type="number" id="DriverAge" name="DriverAge"
               class="mt-1 block w-full px-3 py-2 border border-gray-300 rounded-md shadow-sm focus:ring-blue-500 focus:border-blue-500 sm:text-sm">
        <input type="number" value="${user.id}" name="user_id" class="hidden">
      </div>

      <div>
        <label for="VehiculeType" class="block text-sm font-medium text-gray-700">Vehicule Type :</label>
        <input type="text" id="VehiculeType" name="VehiculeType"
               class="mt-1 block w-full px-3 py-2 border border-gray-300 rounded-md shadow-sm focus:ring-blue-500 focus:border-blue-500 sm:text-sm">
      </div>

      <!-- Policy Expiry Date -->
      <div>
      <label>Is the car for professional use?</label>
        <input type="radio" id="professionalYes" name="isProfessionalUse" value="yes">
        <label for="professionalYes">Yes</label>
        <input type="radio" id="professionalNo" name="isProfessionalUse" value="no">
        <label for="professionalNo">No</label>
      </div>
      <div>
        <label class="block text-sm font-medium text-gray-700">did you had any accidents before ?</label>
        <input type="radio" id="accidentsYes" name="hasAccidents" value="yes">
        <label for="accidentsYes">Yes</label>
        <input type="radio" id="accidentsNo" name="hasAccidents" value="no">
        <label for="accidentsNo">No</label>
      </div>

      <!-- Submit Button -->
      <div class="col-span-2 text-right">
        <button type="submit"
                class="bg-blue-600 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded-lg shadow-md transition duration-300">
          Add Policy
        </button>
      </div>
    </form>
  </div>

  <!-- Existing Car Insurance Policies Table -->
  <div class="mt-8 bg-white p-6 rounded-lg shadow-lg">
    <h2 class="text-xl font-bold mb-6 text-gray-700">Your Car Insurance Policies</h2>
    <table class="min-w-full divide-y divide-gray-200 table-auto">
      <thead class="bg-gray-50">
      <tr>
        <th scope="col" class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">Policy Number</th>
        <th scope="col" class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">Car Model</th>
        <th scope="col" class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">Registration Number</th>
        <th scope="col" class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">Amount (MAD)</th>
        <th scope="col" class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">Expiry Date</th>
        <th scope="col" class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">Actions</th>
      </tr>
      </thead>
      <tbody class="bg-white divide-y divide-gray-200">
      <!-- Example Row -->
      <tr>
        <td class="px-6 py-4 whitespace-nowrap">CAR12345</td>
        <td class="px-6 py-4 whitespace-nowrap">Toyota Corolla</td>
        <td class="px-6 py-4 whitespace-nowrap">AB123CD</td>
        <td class="px-6 py-4 whitespace-nowrap">500,000 MAD</td>
        <td class="px-6 py-4 whitespace-nowrap">2024-12-31</td>
        <td class="px-6 py-4 whitespace-nowrap">
          <a href="/car-insurance/edit/CAR12345" class="text-blue-600 hover:underline">Edit</a> |
          <a href="/car-insurance/delete/CAR12345" class="text-red-600 hover:underline">Delete</a>
        </td>
      </tr>
      <!-- End Example Row -->
      <!-- More policies will be rendered here dynamically -->
      </tbody>
    </table>
  </div>
</div>

</body>
</html>
