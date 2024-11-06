<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Contract Page</title>
  <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet">
</head>
<body class="bg-gray-50 flex items-center justify-center h-screen">

<div class="bg-white rounded-lg shadow-lg p-8 w-full max-w-lg">
  <h2 class="text-2xl font-semibold text-gray-800 mb-6 text-center">Upload Justification File</h2>

  <form action="/insurance/contract"  method="post" >
    <div class="mb-4">
      <input type="hidden" name="insuranceType" value="${type}">
    </div>
    <div class="mb-4">
      <input type="hidden" name="total" value="${total}">
    </div>

    <div class="mb-4">
      <label for="justificationFile" class="block text-gray-700">Justification File:</label>
      <input type="file" id="justificationFile" name="justificationFile" accept=".pdf,.doc,.docx,.jpg,.png" required class="mt-1 block w-full border border-gray-300 rounded-md p-2 focus:ring focus:ring-blue-500" />
    </div>

    <div class="flex items-center justify-between mb-6">
      <div class="flex items-center">
        <input type="checkbox" id="terms" name="terms" required class="mr-2">
        <label for="terms" class="text-gray-600">I agree to the terms and conditions</label>
      </div>
    </div>

    <button type="submit" class="w-full bg-blue-600 text-white font-semibold py-2 rounded-lg hover:bg-blue-700 transition duration-200">Submit</button>
  </form>
</div>

</body>
</html>
