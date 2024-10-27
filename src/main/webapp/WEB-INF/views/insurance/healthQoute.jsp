<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Health Insurance Quote</title>
    <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet">
</head>
<body class="bg-gray-100 flex items-center justify-center min-h-screen">

<div class="bg-white p-8 rounded-lg shadow-lg max-w-lg w-full text-center">
    <h1 class="text-2xl font-semibold text-gray-800 mb-6">Health Insurance Quote</h1>

    <div class="bg-gray-50 p-6 rounded-lg shadow-inner mb-6">
        <h2 class="text-lg font-semibold text-gray-700 mb-4">Quote Details</h2>
        <div class="text-left space-y-2">
            <p><span class="font-semibold text-gray-800">Policy Holder Name:</span> ${healthInsurance.policyHolderName}</p>
            <p><span class="font-semibold text-gray-800">Coverage type:</span> ${healthInsurance.coverageType}</p>
            <p><span class="font-semibold text-gray-800">Patient age:</span> ${healthInsurance.age}</p>
            <p><span class="font-semibold text-gray-800">start Date:</span> ${healthInsurance.startDate}</p>
            <p><span class="font-semibold text-gray-800">end Date:</span> ${healthInsurance.endDate}</p>
            <p><span class="font-semibold text-gray-800">Patient has chronic conditions:</span> ${healthInsurance.hasChronic ? "Yes" : "No"}</p>
            <p><span class="font-semibold text-gray-800">Total Premium:</span>${total}DH</p>
        </div>
    </div>


    <div class="flex justify-center gap-4">
        <form action="/insurance/healthQoute" method="post">
            <input type="text" value="approve" name="resp" class="hidden">
            <button type="submit"
                    class="w-32 bg-green-500 text-white py-2 px-4 rounded-lg hover:bg-green-600 transition">
                Approve
            </button>
        </form>

        <form action="/insurance/healthQoute" method="post">
            <input type="text" value="reject" name="resp" class="hidden">
            <button type="submit"
                    class="w-32 bg-red-500 text-white py-2 px-4 rounded-lg hover:bg-red-600 transition">
                Reject
            </button>
        </form>
    </div>
</div>

</body>
</html>
