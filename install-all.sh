#!/bin/bash

# Navigate to the root folder
cd .

# Loop through each subfolder
for folder in */; do
    # Navigate into the subfolder
    cd "$folder"
    
    # Check if package.json exists
    if [ -f "package.json" ]; then
        echo "Installing node modules in $folder"
        # Remove node_modules folder
        rm -rf node_modules
        # Run npm install
        npm install
    else
        echo "No package.json found in $folder, skipping..."
    fi
    
    # Navigate back to the root folder
    cd ..
done
